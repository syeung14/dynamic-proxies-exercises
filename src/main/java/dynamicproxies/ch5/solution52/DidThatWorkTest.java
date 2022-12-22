/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.solution52;

import org.junit.*;

import static org.junit.Assert.*;

// To run this test, the following must be added to the VM option:
// --add-reads eu.javaspecialists.books.dynamicproxies=eu.javaspecialists.courses.dynamicproxies
public class DidThatWorkTest {
  @Test
  public void testStructure() throws NoSuchMethodException {
    All all = Factory.adapt(All.class, new A(), new B(), new C());
    all.getClass().getDeclaredMethod("foo");
    all.getClass().getDeclaredMethod("bar");
    all.getClass().getDeclaredMethod("baz");
    all.getClass().getDeclaredMethod("happy");
    all.getClass().getDeclaredMethod("feet");
    all.getClass().getDeclaredMethod("mashup");
  }

  @Test
  public void testOutput() {
    All all1 = Factory.adapt(All.class, new A(), new B(), new C());
    assertEquals("A.foo", all1.foo());
    assertEquals("A.bar", all1.bar());
    assertEquals("B.baz", all1.baz());
    assertEquals("C.happy", all1.happy());
    assertEquals("C.feet", all1.feet());
    assertEquals("A.fooA.barB.bazC.happyC.feet", all1.mashup());

    All all2 = Factory.adapt(All.class, new B(), new A(), new C());
    assertEquals("A.foo", all2.foo());
    assertEquals("B.bar", all2.bar());
    assertEquals("B.baz", all2.baz());
    assertEquals("C.happy", all2.happy());
    assertEquals("C.feet", all2.feet());
    assertEquals("A.fooB.barB.bazC.happyC.feet", all2.mashup());
  }
}
