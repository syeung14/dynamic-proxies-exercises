/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.exercise52;

import java.lang.reflect.*;

// TODO: This is similar to the ObjectAdapterHandler, except that it can take
//   an arbitrary number of adapters in the constructor. We then create the
//   chain for all the adapters. The last link in the chain would be a
//   default method handler.
public class MultipleInheritanceHandler implements InvocationHandler {
  public MultipleInheritanceHandler(Class<?> target, Object... adapters) {
  }

  @Override
  public Object invoke(Object proxy, Method method,
                       Object[] args) throws Throwable {
    throw new UnsupportedOperationException("TODO");
  }
}