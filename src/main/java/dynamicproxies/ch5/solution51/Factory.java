/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.solution51;

import eu.javaspecialists.books.dynamicproxies.*;

import java.util.*;

public class Factory {
  private Factory() {}
  public static <K, V> IteratingMap<K, V> create(Map<K, V> adaptee) {
    return Proxies.adapt(IteratingMap.class, adaptee,
        new IteratingMap.IteratingImpl<>(adaptee));
  }
}
