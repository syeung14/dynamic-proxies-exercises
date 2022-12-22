/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch4.solution41;

import eu.javaspecialists.books.dynamicproxies.*;

import java.util.concurrent.*;

public class Factory {
  private Factory() {}

  public static <K, V> CustomMap<K, V> create() {
    return Proxies.filter(CustomMap.class, new ConcurrentHashMap<>());
  }
}
