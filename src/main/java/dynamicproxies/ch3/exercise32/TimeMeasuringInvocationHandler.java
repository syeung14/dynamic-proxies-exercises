/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch3.exercise32;

import dynamicproxies.util.measurement.*;

import java.lang.reflect.*;
import java.util.*;

// TODO: This special TimeMeasuringInvocationHandler must wrap all method calls
//   in our TimeMeasuringHandler, similar to how we solved exercise 2.2.
// TODO: Any interface in the returnTypesToRecursivelyProxy set should be
//   recursively proxied.
public class TimeMeasuringInvocationHandler implements InvocationHandler {
  public TimeMeasuringInvocationHandler(
      Object instance, TimeMeasuringHandler handler,
      Set<Class<?>> returnTypesToRecursivelyProxy) {
  }

  @Override
  @SuppressWarnings("unchecked, rawtypes")
  public Object invoke(Object proxy, Method method,
                       Object[] args) throws Throwable {
    throw new UnsupportedOperationException("TODO");
  }
}