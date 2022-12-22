/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.solution53;

import eu.javaspecialists.books.dynamicproxies.util.*;
import eu.javaspecialists.books.dynamicproxies.util.chain.*;

import java.lang.reflect.*;
import java.util.*;

public class MappingHandler implements InvocationHandler {
  private final ChainedInvocationHandler chain;

  public MappingHandler(Class<?> target, Object component,
                        Map<Method, Method> mapping) {
    VTable vt = VTables.newVTable(component.getClass(), target);
    VTable defaultVT = VTables.newDefaultMethodVTable(target);

    chain =
        new MappingChainedInvocationHandler(component, mapping,
            new VTableHandler(component, vt,
                new VTableDefaultMethodsHandler(
                    defaultVT, null)));

    chain.checkAllMethodsAreHandled(target);
  }

  @Override
  public Object invoke(Object proxy,
                       Method method,
                       Object[] args) throws Throwable {
    return chain.invoke(proxy, method, args);
  }
}