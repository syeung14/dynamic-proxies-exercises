/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch4.solution42b;

import eu.javaspecialists.books.dynamicproxies.util.*;
import eu.javaspecialists.books.dynamicproxies.util.chain.*;

import java.lang.reflect.*;
import java.util.*;

// Solution using the strategy design pattern
class StandardObjectMethodsInvocationHandler extends ChainedInvocationHandler {
  private static final Map<MethodKey, InvocationHandler> actionMap =
      Map.of(
          new MethodKey(Object.class, "equals", Object.class),
          StandardObjectMethodsInvocationHandler::standardEquals,
          new MethodKey(Object.class, "hashCode"),
          StandardObjectMethodsInvocationHandler::standardHashCode,
          new MethodKey(Object.class, "toString"),
          StandardObjectMethodsInvocationHandler::standardToString);

  public StandardObjectMethodsInvocationHandler(ChainedInvocationHandler next) {
    super(next);
  }

  @Override
  public Object invoke(Object proxy, Method method,
                       Object[] args) throws Throwable {
    return actionMap.getOrDefault(
        new MethodKey(method), super::invoke
    ).invoke(proxy, method, args);
  }

  private static boolean standardEquals(Object proxy, Method method,
                                        Object[] args) {
    return proxy == args[0];
  }
  private static String standardToString(Object proxy, Method method,
                                         Object[] args) {
    return proxy.getClass().getName() + "@" + Integer.toHexString(
        standardHashCode(proxy, method, args)
    );
  }
  private static int standardHashCode(Object proxy, Method method,
                                      Object[] args) {
    return System.identityHashCode(proxy);
  }
}