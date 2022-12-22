/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch2.solution21;

import java.io.*;
import java.util.*;
import java.util.function.*;

public class CustomHashMap<K, V> implements CustomMap<K, V>, Serializable {
  private final Map<K, V> map = new HashMap<>();

  @Override
  public int size() {
    return map.size();
  }
  @Override
  public V get(Object key) {
    return map.get(key);
  }
  @Override
  public V put(K key, V value) {
    return map.put(key, value);
  }
  @Override
  public V remove(Object key) {
    return map.remove(key);
  }
  @Override
  public void clear() {
    map.clear();
  }
  @Override
  public void forEach(BiConsumer<? super K, ? super V> action) {
    map.forEach(action);
  }
  @Override
  public String toString() {
    return map.toString();
  }
  @Override
  public int hashCode() {
    return map.hashCode();
  }
  @Override
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CustomMap)) return false;

    if (o instanceof CustomHashMap) {
      return this.map.equals(((CustomHashMap<?, ?>) o).map);
    }
    return o.equals(this); // reversing the equals() condition
  }
}