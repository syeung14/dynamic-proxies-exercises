/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.solution53;

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
    this.component = Objects.requireNonNull(component, "component==null");
    this.mapping = Objects.requireNonNull(mapping, "mapping==null");
    this.mapping.forEach(
        (k, v) -> {
          if (!Arrays.equals(k.getParameterTypes(), v.getParameterTypes())) {
            throw new IllegalArgumentException(
                "Mismatched parameter types for methods " + k + " and " + v);
          }
          if (!k.getReturnType().equals(v.getReturnType())) {
            throw new IllegalArgumentException(
                "Different return types for methods " + k + " and " + v);
          }
        }
    );
  }

  public Object invoke(Object proxy, Method method, Object[] args)
      throws Throwable {
    Method match = mapping.get(method);
    return match != null ? match.invoke(component, args) :
               super.invoke(proxy, method, args);
  }

  protected Stream<Method> findUnhandledMethods(Class<?>... targets) {
    return super.findUnhandledMethods(targets)
               .filter((method) -> this.mapping.get(method) == null);
  }
}