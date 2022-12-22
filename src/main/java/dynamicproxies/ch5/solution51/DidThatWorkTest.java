/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.solution51;

import org.junit.*;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;

import static org.junit.Assert.*;

// To run this test, the following must be added to the VM option:
// --add-reads eu.javaspecialists.books.dynamicproxies=eu.javaspecialists.courses.dynamicproxies
// --add-opens java.base/java.lang=eu.javaspecialists.books.dynamicproxies
public class DidThatWorkTest {
  @Test
  public void testIteratingMapCreation() throws NoSuchMethodException {
    IteratingMap<Integer, Integer> map =
        Factory.create(new ConcurrentHashMap<>());
    map.getClass().getDeclaredMethod("stream");
    map.getClass().getDeclaredMethod("parallelStream");
    map.getClass().getDeclaredMethod("iterator");
  }

  @Test
  public void testIterator() {
    IteratingMap<Integer, Integer> map =
        Factory.create(new ConcurrentHashMap<>());
    for (int i = 0; i <= 100; i++) {
      map.put(i, i * i);
    }

    int sum = 0;
    for (Map.Entry<Integer, Integer> entry : map) {
      sum += entry.getKey();
    }
    assertEquals(5050, sum);
  }

  @Test
  public void testStream() {
    IteratingMap<Integer, Integer> map =
        Factory.create(new ConcurrentHashMap<>());
    for (int i = 0; i <= 100; i++) {
      map.put(i, i * i);
    }

    int sum = map.stream().mapToInt(Map.Entry::getKey).sum();
    assertEquals(5050, sum);
  }

  @Test
  public void testParallelStream() {
    IteratingMap<Integer, Integer> map =
        Factory.create(new ConcurrentHashMap<>());
    for (int i = 0; i <= 100; i++) {
      map.put(i, i * i);
    }

    int sum = map.parallelStream().mapToInt(Map.Entry::getKey).sum();
    assertEquals(5050, sum);
  }

  @Test
  public void testIteratingMapIsProxy() {
    assertTrue("IteratingMap instance should be a dynamic proxy",
        (Object) Factory.create(new ConcurrentHashMap<>()) instanceof Proxy);
  }
  @Test
  public void testIteratingMapIsInterface() {
    assertTrue("IteratingMap instance should be an interface",
        IteratingMap.class.isInterface());
  }
  @Test
  public void testIteratingMapStreamMethodsAreDefaultMethods() throws NoSuchMethodException {
    assertTrue("IteratingMap.stream() method should be default method",
        IteratingMap.class.getDeclaredMethod("stream").isDefault());
    assertTrue("IteratingMap.parallelStream() method should be default method",
        IteratingMap.class.getDeclaredMethod("parallelStream").isDefault());
  }
  @Test
  public void testIteratingMapIteratorMethodIsAbstractMethods() throws NoSuchMethodException {
    assertTrue("IteratingMap.iterator() method should be abstract method",
        Modifier.isAbstract(IteratingMap.class.getMethod("iterator").getModifiers()));
  }
}
