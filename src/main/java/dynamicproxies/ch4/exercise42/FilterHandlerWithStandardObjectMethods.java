/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch4.exercise42;

import java.lang.reflect.*;

class FilterHandlerWithStandardObjectMethods implements InvocationHandler {
  public FilterHandlerWithStandardObjectMethods(
      Class<?> filter, Object component) {
    // TODO: This would look similar to the FilterHandler constructor, but with
    //   StandardObjectMethodsInvocationHandler as the first handler in the
    //   chain of responsibility
  }

  @Override
  public Object invoke(Object proxy,
                       Method method,
                       Object[] args) throws Throwable {
    throw new UnsupportedOperationException("TODO");
  }
}