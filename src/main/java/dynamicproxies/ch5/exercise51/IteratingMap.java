/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.exercise51;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

// TODO: Use dynamic object adapter to convert a map to an Iterator

// TODO: convert to interface
public class IteratingMap<K, V> implements Map<K, V>, Iterable<Map.Entry<K, V>> {
  private final Map<K, V> adaptee;

  public IteratingMap(Map<K, V> adaptee) {
    this.adaptee = adaptee;
  }

  // TODO: convert to default method on interface
  public Stream<Entry<K, V>> stream() {
    return StreamSupport.stream(spliterator(), false);
  }
  // TODO: convert to default method on interface
  public Stream<Entry<K, V>> parallelStream() {
    return StreamSupport.stream(spliterator(), true);
  }
  // TODO: move to method in public inner class as an adapter
  public Iterator<Entry<K, V>> iterator() {
    return adaptee.entrySet().iterator();
  }


  // TODO: Remove all these methods and replace with dynamic object adapter
  @Override
  public int size() {
    return adaptee.size();
  }
  @Override
  public boolean isEmpty() {
    return adaptee.isEmpty();
  }
  @Override
  public boolean containsKey(Object key) {
    return adaptee.containsKey(key);
  }
  @Override
  public boolean containsValue(Object value) {
    return adaptee.containsValue(value);
  }
  @Override
  public V get(Object key) {
    return adaptee.get(key);
  }
  @Override
  public V put(K key, V value) {
    return adaptee.put(key, value);
  }
  @Override
  public V remove(Object key) {
    return adaptee.remove(key);
  }
  @Override
  public void putAll(Map<? extends K, ? extends V> m) {
    adaptee.putAll(m);
  }
  @Override
  public void clear() {
    adaptee.clear();
  }
  @Override
  public Set<K> keySet() {
    return adaptee.keySet();
  }
  @Override
  public Collection<V> values() {
    return adaptee.values();
  }
  @Override
  public Set<Entry<K, V>> entrySet() {
    return adaptee.entrySet();
  }
  @Override
  public boolean equals(Object o) {
    return adaptee.equals(o);
  }
  @Override
  public int hashCode() {
    return adaptee.hashCode();
  }
  @Override
  public V getOrDefault(Object key, V defaultValue) {
    return adaptee.getOrDefault(key, defaultValue);
  }
  @Override
  public void forEach(BiConsumer<? super K, ? super V> action) {
    adaptee.forEach(action);
  }
  @Override
  public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
    adaptee.replaceAll(function);
  }
  @Override
  public V putIfAbsent(K key, V value) {
    return adaptee.putIfAbsent(key, value);
  }
  @Override
  public boolean remove(Object key, Object value) {
    return adaptee.remove(key, value);
  }
  @Override
  public boolean replace(K key, V oldValue, V newValue) {
    return adaptee.replace(key, oldValue, newValue);
  }
  @Override
  public V replace(K key, V value) {
    return adaptee.replace(key, value);
  }
  @Override
  public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
    return adaptee.computeIfAbsent(key, mappingFunction);
  }
  @Override
  public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
    return adaptee.computeIfPresent(key, remappingFunction);
  }
  @Override
  public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
    return adaptee.compute(key, remappingFunction);
  }
  @Override
  public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
    return adaptee.merge(key, value, remappingFunction);
  }
}