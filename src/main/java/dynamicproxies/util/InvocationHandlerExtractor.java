/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.util;

import eu.javaspecialists.books.dynamicproxies.handlers.*;

import java.lang.reflect.*;

public class InvocationHandlerExtractor {
  public static InvocationHandler getInvocationHandler(Object proxy) {
    InvocationHandler h = Proxy.getInvocationHandler(proxy);
    if (h instanceof ExceptionUnwrappingInvocationHandler) {
      var eh = (ExceptionUnwrappingInvocationHandler) h;
      return eh.getNestedInvocationHandler();
    }
    return h;
  }
}
