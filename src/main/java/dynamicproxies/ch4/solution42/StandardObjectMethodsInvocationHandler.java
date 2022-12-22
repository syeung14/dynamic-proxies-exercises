/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch4.solution42;

import eu.javaspecialists.books.dynamicproxies.util.*;
import eu.javaspecialists.books.dynamicproxies.util.chain.*;

import java.lang.reflect.*;

class StandardObjectMethodsInvocationHandler extends ChainedInvocationHandler {
  private final static MethodKey EQUALS_KEY =
      new MethodKey(Object.class, "equals", Object.class);
  private final static MethodKey HASHCODE_KEY =
      new MethodKey(Object.class, "hashCode");
  private final static MethodKey TOSTRING_KEY =
      new MethodKey(Object.class, "toString");

  public StandardObjectMethodsInvocationHandler(ChainedInvocationHandler next) {
    super(next);
  }

  @Override
  public Object invoke(Object proxy, Method method,
                       Object[] args) throws Throwable {
    if (EQUALS_KEY.matches(method)) {
      return proxy == args[0];
    } else if (HASHCODE_KEY.matches(method)) {
      return System.identityHashCode(proxy);
    } else if (TOSTRING_KEY.matches(method)) {
      return proxy.getClass().getName() + "@" +
                 Integer.toHexString(System.identityHashCode(proxy));
    }
    return super.invoke(proxy, method, args);
  }
}