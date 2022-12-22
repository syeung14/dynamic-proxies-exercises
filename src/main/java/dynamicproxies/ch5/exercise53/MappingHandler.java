/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.exercise53;

import eu.javaspecialists.books.dynamicproxies.util.chain.*;

import java.lang.reflect.*;
import java.util.*;

public class MappingHandler implements InvocationHandler {
  private final ChainedInvocationHandler chain;

  public MappingHandler(Class<?> target, Object component,
                        Map<Method, Method> mapping) {
    // TODO: Create a chain that has first the MappingChainedInvocationHandler
    //  and then a VTableHandler for the rest of the component methods and
    //  lastly a VTableDefaultMethodsHandler for the default interface methods.

    // TODO: Check that all methods in target interface are handled
    throw new UnsupportedOperationException("TODO");
  }

  @Override
  public Object invoke(Object proxy,
                       Method method,
                       Object[] args) throws Throwable {
    return chain.invoke(proxy, method, args);
  }
}