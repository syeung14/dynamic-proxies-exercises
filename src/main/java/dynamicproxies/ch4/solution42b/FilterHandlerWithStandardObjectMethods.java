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

class FilterHandlerWithStandardObjectMethods implements InvocationHandler {
  private final ChainedInvocationHandler chain;

  public FilterHandlerWithStandardObjectMethods(
      Class<?> filter, Object component) {
    VTable vt = VTables.newVTable(component.getClass(), filter);
    VTable defaultVT = VTables.newDefaultMethodVTable(filter);

    chain =
        new StandardObjectMethodsInvocationHandler(
            new VTableHandler(component, vt,
                new VTableDefaultMethodsHandler(
                    defaultVT, null)));

    chain.checkAllMethodsAreHandled(filter);
  }

  @Override
  public Object invoke(Object proxy,
                       Method method,
                       Object[] args) throws Throwable {
    return chain.invoke(proxy, method, args);
  }
}