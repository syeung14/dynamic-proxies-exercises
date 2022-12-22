/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch4.exercise42;

import eu.javaspecialists.books.dynamicproxies.util.chain.*;

import java.lang.reflect.*;

// TODO: This invocation handler should handle equals(Object), hashcode() and
//  toString() only. All other methods are passed down the chain.
class StandardObjectMethodsInvocationHandler extends ChainedInvocationHandler {
  public StandardObjectMethodsInvocationHandler(ChainedInvocationHandler next) {
    super(next);
  }

  @Override
  public Object invoke(Object proxy, Method method,
                       Object[] args) throws Throwable {
    // TODO: replicate the behavior of Object for the methods toString(),
    //  equals(Object) and hashCode().  See README.txt for more details.
    return super.invoke(proxy, method, args);
  }
}