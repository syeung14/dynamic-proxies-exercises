/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.solution53;

import eu.javaspecialists.books.dynamicproxies.*;

import java.lang.reflect.*;
import java.util.*;

public class Factory {
  private Factory() {}

  public static <F> F map(
      Class<? super F> target, Object component, Map<Method, Method> mapping) {
    Objects.requireNonNull(component, "component==null");
    Objects.requireNonNull(mapping, "mapping==null");
    return Proxies.castProxy(target,
        new MappingHandler(target, component, mapping));
  }

  private static final Map<Method, Method> mapping;

  static {
    try {
      mapping = Map.of(
          Singer.class.getMethod("sing"), Rapper.class.getMethod("talk")
      );
    } catch (NoSuchMethodException e) {
      throw new Error(e);
    }
  }

  public static Singer convert(Rapper rapper) {
    return map(Singer.class, rapper, mapping);
  }
}