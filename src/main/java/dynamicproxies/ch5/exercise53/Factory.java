/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.exercise53;

import eu.javaspecialists.books.dynamicproxies.*;

import java.lang.reflect.*;
import java.util.*;

public class Factory {
  private Factory() {}

  // TODO: return a dynamic proxy with a MappingHandler as InvocationHandler
  public static <F> F map(
      Class<? super F> target, Object component, Map<Method, Method> mapping) {
    throw new UnsupportedOperationException("TODO");
  }

  // TODO: use the map() method to return a dynamic proxy using a MappingHandler
  public static Singer convert(Rapper rapper) {
    return Proxies.adapt(
        Singer.class, rapper, new SingingRapperAdapter(rapper));
  }
}