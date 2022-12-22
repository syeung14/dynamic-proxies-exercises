/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch2.exercise21;

import java.util.function.*;

// TODO: make this hand-crafted virtual proxy class serializable
// TODO: add equals(), hashCode() and toString(), delegating to getRealMap()
public class VirtualCustomMap<K, V> implements CustomMap<K, V> {
  private final Supplier<CustomMap<K, V>> mapSupplier;
  private CustomMap<K, V> realMap;
  public VirtualCustomMap(Supplier<CustomMap<K, V>> mapSupplier) {
    this.mapSupplier = mapSupplier;
  }
  private CustomMap<K, V> getRealMap() {
    if (realMap == null) realMap = mapSupplier.get();
    return realMap;
  }
  @Override
  public int size() {
    return getRealMap().size();
  }
  @Override
  public V get(Object key) {
    return getRealMap().get(key);
  }
  @Override
  public V put(K key, V value) {
    return getRealMap().put(key, value);
  }
  @Override
  public V remove(Object key) {
    return getRealMap().remove(key);
  }
  @Override
  public void clear() {
    getRealMap().clear();
  }
  @Override
  public void forEach(BiConsumer<? super K, ? super V> action) {
    getRealMap().forEach(action);
  }
}