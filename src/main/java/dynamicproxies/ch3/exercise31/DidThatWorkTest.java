/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch3.exercise31;

import dynamicproxies.util.*;
import org.junit.*;

import java.lang.reflect.*;

import static org.junit.Assert.*;

public class DidThatWorkTest {
  @Test
  public void testCustomHashMapClassStructure() throws NoSuchMethodException {
    CustomHashMap.class.getDeclaredMethod("toString");
    CustomHashMap.class.getDeclaredMethod("hashCode");
    Method equals = CustomHashMap.class.getDeclaredMethod("equals", Object.class);
    assertTrue("Method equals() should be final to avoid break in symmetry",
        Modifier.isFinal(equals.getModifiers()));
  }

  @Test
  public void testForExistenceOfProxy() {
    assertTrue("Virtual Custom Map should be dynamic proxy",
        Factory.createVirtualCustomMap() instanceof Proxy);
  }

  @Test
  public void testOldHandCraftedProxyIsDeleted() {
    try {
      String name = DidThatWorkTest.class.getPackageName() + ".Virtual" +
                        'C' + "ustomMap";
      Class.forName(name);
      fail("Class " + name + " should be removed");
    } catch (ClassNotFoundException success) { }
  }

  @Test
  public void testCustomHashMapEquals() {
    CustomMap<Integer, Integer> squares1 = Factory.createCustomMap();
    CustomMap<Integer, Integer> squares2 = Factory.createCustomMap();
    for (int i = 1; i <= 10; i++) {
      squares1.put(i, i * i);
      squares2.put(i, i * i);
    }

    assertEquals(squares1, squares2);
    assertEquals(squares2, squares1);
  }

  @Test
  public void testSubclassOfCustomHashMap() {
    CustomMap<Integer, Integer> squares1 = Factory.createCustomMap();
    CustomMap<Integer, Integer> squares2 = new CustomHashMap<>() {}; // anonymous subclass
    for (int i = 1; i <= 10; i++) {
      squares1.put(i, i * i);
      squares2.put(i, i * i);
    }

    assertEquals(squares1.getClass().getSimpleName() + ".equals() not implemented correctly", squares1, squares2);
    assertEquals(squares1.getClass().getSimpleName() + ".equals() not implemented correctly", squares2, squares1);
  }

  @Test
  public void testVirtualCustomMapEquals() {
    CustomMap<Integer, Integer> squares1 = Factory.createCustomMap();
    CustomMap<Integer, Integer> squares2 = Factory.createVirtualCustomMap();
    for (int i = 1; i <= 10; i++) {
      squares1.put(i, i * i);
      squares2.put(i, i * i);
    }

    assertEquals(squares1, squares2);
    assertEquals(squares2, squares1);
  }

  @Test
  public void testPlainCustomHashMap() {
    CustomMap<Integer, Integer> squares1 = Factory.createCustomMap();
    CustomMap<Integer, Integer> squares2 = Factory.createCustomMap();
    for (int i = 1; i <= 10; i++) {
      squares1.put(i, i * i);
      squares2.put(i, i * i);
    }

    assertEquals(squares1, squares2);
    assertEquals(squares2, squares1);

    CustomMap<Integer, Integer> squares3 =
        Serializer.serializeDeserialize(squares1);
    assertEquals(squares1, squares3);
    assertEquals(squares3, squares1);
    CustomMap<Integer, Integer> squares4 =
        Serializer.serializeDeserialize(squares2);
    assertEquals(squares1, squares4);
    assertEquals(squares4, squares1);
  }
  @Test
  public void testVirtualCustomMap() {
    CustomMap<Integer, Integer> squares1 = Factory.createCustomMap();
    CustomMap<Integer, Integer> squares2 = Factory.createVirtualCustomMap();
    for (int i = 1; i <= 10; i++) {
      squares1.put(i, i * i);
      squares2.put(i, i * i);
    }

    assertEquals(squares1, squares2);
    assertEquals(squares2, squares1);

    CustomMap<Integer, Integer> squares3 =
        Serializer.serializeDeserialize(squares1);
    assertEquals(squares1, squares3);
    assertEquals(squares3, squares1);
    CustomMap<Integer, Integer> squares4 =
        Serializer.serializeDeserialize(squares2);
    assertEquals(squares1, squares4);
    assertEquals(squares4, squares1);
  }
}
