/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch4.exercise42;

import eu.javaspecialists.books.dynamicproxies.*;
import org.junit.*;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

import static org.junit.Assert.*;

public class DidThatWorkTest {
  private final List<Supplier<Queue<Integer>>> queueSuppliers =
      List.of(
          () -> new ArrayBlockingQueue<>(5),
          ArrayDeque::new,
          LinkedBlockingDeque::new,
          LinkedBlockingQueue::new,
          ConcurrentLinkedQueue::new,
          ConcurrentLinkedDeque::new,
          LinkedList::new,
          LinkedTransferQueue::new,
          SynchronousQueue::new,
          PriorityQueue::new,
          PriorityBlockingQueue::new
      );

  @Test
  public void testΟυράStructure() {
    assertFalse("Ουρά should not extend Queue",
        Queue.class.isAssignableFrom(Ουρά.class));
    assertEquals(6, Ουρά.class.getDeclaredMethods().length);
  }

  @Test
  public void testMethodsFilteredAway() {
    queueSuppliers.forEach(this::testMethodsFilteredAway);
  }

  private void testMethodsFilteredAway(Supplier<Queue<Integer>> supplier) {
    Class<?> clazz = Ουρές.create(supplier).getClass();
    checkDoesNotContain(clazz, "size");
    checkDoesNotContain(clazz, "add", Object.class);
    checkDoesNotContain(clazz, "clear");
    checkDoesNotContain(clazz, "addAll", Collection.class);
    checkDoesNotContain(clazz, "contains", Object.class);
  }

  private void checkDoesNotContain(Class<?> clazz, String methodName,
                                   Class<?>... parameterTypes) {
    try {
      clazz.getMethod(methodName, parameterTypes);
      fail(clazz + " should not have " + methodName + "() method");
    } catch (NoSuchMethodException expected) {
    }
  }

  @Test
  public void testOfferPollMethods() {
    queueSuppliers.forEach(this::testOfferPollMethods);
  }

  private void testOfferPollMethods(Supplier<Queue<Integer>> supplier) {
    Ουρά<Integer> q = Ουρές.create(supplier);
    for (int i = 0; i < 10; i++) {
      if (q.offer(i)) {
        assertFalse(q.isEmpty());
        assertNotNull(q.peek());
        assertNotNull(q.poll());
        assertTrue(q.isEmpty());
      } else {
        assertNull(q.poll());
      }
    }

    int offered = 0;
    for (int i = 0; i < 100; i++) {
      if (q.offer(i)) {
        assertFalse(q.isEmpty());
        offered++;
        assertNotNull(q.peek());
      }
    }
    for (int i = 0; i < offered; i++) {
      assertNotNull(q.poll());
    }
    assertTrue(q.isEmpty());
  }

  @Test
  public void testObjectMethods() {
    queueSuppliers.forEach(this::testObjectMethods);
  }

  private void testObjectMethods(Supplier<Queue<Integer>> supplier) {
    Ουρά<Integer> q = Ουρές.create(supplier);
    assertTrue("Should use default Object.toString() method implementation",
        q.toString().startsWith(q.getClass().getName()));
    assertEquals(q, q);
    assertNotEquals(q, new LinkedList<>());
    assertNotEquals(q, Ουρές.create(supplier));
    assertEquals(System.identityHashCode(q), q.hashCode());
  }

  @Test
  public void testStandardObjectMethodsInvocationHandlerEquals()
      throws Throwable {
    StandardObjectMethodsInvocationHandler handler =
        new StandardObjectMethodsInvocationHandler(null);
    String test1 = new String("Test");
    String test2 = new String("Test");
    Method equals = Object.class.getDeclaredMethod("equals", Object.class);
    assertFalse("equals() should compare only with ==",
        (boolean) handler.invoke(test1, equals, new Object[] {test2}));
    assertTrue("equals() should compare only with ==",
        (boolean) handler.invoke(test1, equals, new Object[] {test1}));
    assertTrue("equals() should compare only with ==",
        (boolean) handler.invoke(test2, equals, new Object[] {test2}));
  }

  @Test
  public void testStandardObjectMethodsInvocationHandlerHashCode()
      throws Throwable {
    StandardObjectMethodsInvocationHandler handler =
        new StandardObjectMethodsInvocationHandler(null);
    String test = new String("Test");
    Method hashCode = Object.class.getDeclaredMethod("hashCode");
    assertEquals("hashCode() should return the System.identityHashCode()",
        System.identityHashCode(test), handler.invoke(test, hashCode, null));
    assertNotEquals("hashCode() should return the System.identityHashCode()",
        test.hashCode(), handler.invoke(test, hashCode, null));
  }

  @Test
  public void testStandardObjectMethodsInvocationHandlerToString()
      throws Throwable {
    StandardObjectMethodsInvocationHandler handler =
        new StandardObjectMethodsInvocationHandler(null);
    String test = new String("Test");
    Method toString = Object.class.getDeclaredMethod("toString");
    String expected = test.getClass().getName() + "@" +
                          Integer.toHexString(System.identityHashCode(test));
    assertEquals("toString() should return the standard Object toString()",
        expected, handler.invoke(test, toString, null));
    assertNotEquals("toString() should return the standard Object toString()",
        test.toString(), handler.invoke(test, toString, null));
  }

  @Test
  public void testOverridenToStringMethod() throws Throwable {
    Collection<String> test = Arrays.asList("Hello", "World");
    List<String> filter = Proxies.castProxy(List.class,
        new FilterHandlerWithStandardObjectMethods(List.class, test));
    assertEquals(filter, filter);
    assertNotEquals(filter, test);
    assertEquals(test, filter);
    assertEquals(test, test);

    assertNotEquals(test.hashCode(), filter.hashCode());
    assertEquals(System.identityHashCode(filter), filter.hashCode());
  }
}