/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch4.exercise41;

import org.junit.*;

import java.lang.reflect.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;

import static org.junit.Assert.*;

public class DidThatWorkTest {
  @Test
  public void testStructure() {
    assertTrue("Factory.create() should return a dynamic proxy instance",
        Factory.create() instanceof Proxy);
  }

  @Test
  public void testCustomHashMapDeleted() {
    try {
      String name = DidThatWorkTest.class.getPackageName() + ".Custom" + 'H' + "ashMap";
      Class.forName(name);
      fail("Class " + name + " should be deleted and replaced with dynamic proxy");
    } catch (ClassNotFoundException success) {
    }
  }

  @Test
  public void testEqualsAndHashCodePresent() throws NoSuchMethodException {
    Factory.create().getClass().getDeclaredMethod("equals", Object.class);
    Factory.create().getClass().getDeclaredMethod("hashCode");
  }

  private static final int SQUARES = 46_000;

  @Test
  public void testCustomHashMap() {
    CustomMap<Integer, Integer> map = Factory.create();
    try {
      IntStream.range(0, SQUARES)
          .parallel()
          .forEach(i -> map.put(i, i * i));
    } catch (Exception e) {
      System.err.println(e); // carry on with check
    }
    // count actual entries
    var entries = new LongAdder();
    map.forEach((k, v) -> entries.increment());

    assertTrue("entries=" + entries + ", " +
                   "map.size=" + map.size(),
        entries.intValue() == map.size());

    assertEquals("map.size() should be " + SQUARES + " in a thread-safe map",
        SQUARES, map.size());
  }
}