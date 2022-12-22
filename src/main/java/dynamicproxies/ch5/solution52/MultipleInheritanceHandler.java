/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.solution52;

import eu.javaspecialists.books.dynamicproxies.util.*;
import eu.javaspecialists.books.dynamicproxies.util.chain.*;

import java.lang.reflect.*;

public class MultipleInheritanceHandler implements InvocationHandler {
  private final ChainedInvocationHandler chain;

  public MultipleInheritanceHandler(Class<?> target, Object... adapters) {
    VTable defaultVT = VTables.newDefaultMethodVTable(target);
    ChainedInvocationHandler tempChain =
        new VTableDefaultMethodsHandler(defaultVT, null);

    for (int i = adapters.length - 1; i >= 0; i--) {
      Object adapter = adapters[i];
      VTable adapterVT = VTables.newVTable(adapter.getClass(), target);
      tempChain = new VTableHandler(adapter, adapterVT, tempChain);
    }

    chain = tempChain;
    chain.checkAllMethodsAreHandled(target);
  }

  @Override
  public Object invoke(Object proxy, Method method,
                       Object[] args) throws Throwable {
    try {
      return chain.invoke(proxy, method, args);
    } catch (InvocationTargetException e) {
      throw e.getCause();
    }
  }
}