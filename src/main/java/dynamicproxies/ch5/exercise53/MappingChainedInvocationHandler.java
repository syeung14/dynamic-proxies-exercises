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
import java.util.stream.*;

class MappingChainedInvocationHandler extends ChainedInvocationHandler {
  private final Object component;
  private final Map<Method, Method> mapping;

  public MappingChainedInvocationHandler(Object component,
                                         Map<Method, Method> mapping,
                                         ChainedInvocationHandler next) {
    super(next);
    // TODO: check that component and mapping are not null
    // TODO: check that all method pairs in mapping have the same parameter
    //  and return types.
    throw new UnsupportedOperationException("TODO");
  }

  public Object invoke(Object proxy, Method method, Object[] args)
      throws Throwable {
    // TODO: try find a match in our mapping Map<Method, Method>, otherwise
    //  pass the call down the chain.
    throw new UnsupportedOperationException("TODO");
  }

  @Override
  protected Stream<Method> findUnhandledMethods(Class<?>... targets) {
    // TODO: filter out unhandled methods, similar to VTableHandler
    throw new UnsupportedOperationException("TODO");
  }
}