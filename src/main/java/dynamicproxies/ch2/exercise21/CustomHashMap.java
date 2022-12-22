/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch2.exercise21;

import java.util.*;
import java.util.function.*;

// TODO: make this class serializable
// TODO: Implement equals() so that we can transparently compare this class
//   to proxies of CustomMap. (see the book for how to do this)
public class CustomHashMap<K, V> implements CustomMap<K, V> {
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
}
