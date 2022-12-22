/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.exercise51;

import java.util.*;

// TODO: Return a dynamic object adapter using Proxies.adapt()
public class Factory {
  private Factory() {}
  static <K, V> IteratingMap<K, V> create(Map<K, V> adaptee) {
    return new IteratingMap<>(adaptee);
  }
}