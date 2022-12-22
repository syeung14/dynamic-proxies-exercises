/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.solution51;

import java.util.*;
import java.util.stream.*;

public interface IteratingMap<K, V> extends Map<K, V>, Iterable<Map.Entry<K, V>> {
  default Stream<Entry<K, V>> stream() {
    return StreamSupport.stream(spliterator(), false);
  }
  default Stream<Entry<K, V>> parallelStream() {
    return StreamSupport.stream(spliterator(), true);
  }

  class IteratingImpl<K, V> {
    private final Map<K, V> map;
    public IteratingImpl(Map<K, V> map) {
      this.map = map;
    }
    public Iterator<Map.Entry<K, V>> iterator() {
      return map.entrySet().iterator();
    }
  }
}