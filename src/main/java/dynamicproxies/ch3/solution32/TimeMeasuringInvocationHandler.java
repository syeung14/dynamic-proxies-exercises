/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch3.solution32;

import dynamicproxies.util.measurement.*;

import java.lang.reflect.*;
import java.util.*;

public class TimeMeasuringInvocationHandler implements InvocationHandler {
  private final Object instance;
  private final TimeMeasuringHandler handler;
  private final Set<Class<?>> returnTypesToRecursivelyProxy;

  public TimeMeasuringInvocationHandler(
      Object instance, TimeMeasuringHandler handler,
      Set<Class<?>> returnTypesToRecursivelyProxy) {
    this.instance = Objects.requireNonNull(instance, "instance==null");
    this.handler = Objects.requireNonNull(handler, "handler==null");
    for (Class<?> intf : returnTypesToRecursivelyProxy) {
      if (!intf.isInterface())
        throw new IllegalArgumentException(intf + " is not an interface");
    }
    this.returnTypesToRecursivelyProxy = returnTypesToRecursivelyProxy;
  }

  @Override
  @SuppressWarnings("unchecked, rawtypes")
  public Object invoke(Object proxy, Method method,
                       Object[] args) throws Throwable {
    String className = method.getDeclaringClass().getName();
    String methodName = method.getName();
    try (var measurer = handler.start(className, methodName, args)) {
      Object result = method.invoke(instance, args);
      Class returnType = method.getReturnType();
      if (returnTypesToRecursivelyProxy.contains(returnType))
        return Factory.measureTime(returnType, result, handler,
            returnTypesToRecursivelyProxy);
      else return result;
    }
  }
}