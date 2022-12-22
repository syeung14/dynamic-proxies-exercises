/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch4.exercise41;

import java.util.*;

public class Factory {
  private Factory() {}

  // TODO: Change to return a Proxies.filter() and with a ConcurrentHashMap
  public static <K, V> CustomMap<K, V> create() {
    return new CustomHashMap<>(new HashMap<>());
  }
}
