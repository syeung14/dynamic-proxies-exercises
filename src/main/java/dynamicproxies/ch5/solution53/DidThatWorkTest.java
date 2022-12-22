/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.solution53;

import dynamicproxies.util.*;
import eu.javaspecialists.books.dynamicproxies.util.chain.*;
import org.junit.*;

import java.lang.reflect.*;
import java.util.*;

import static org.junit.Assert.*;

public class DidThatWorkTest {
  private static final String BOOM_BAP_TALK = new BoomBapRapper().talk();
  private static final String GANGSTA_TALK = new GangstaRapper().talk();
  private static final String EMO_TALK = new EmoRapper().talk();
  private static final String RAPPER_DANCE = ((Rapper) () -> "").dance();

  @Test
  public void testSingingRappers() {
    Singer boomBapSinger = Factory.convert(new BoomBapRapper());
    assertEquals(BOOM_BAP_TALK, boomBapSinger.sing());
    Singer gangstaSinger = Factory.convert(new GangstaRapper());
    assertEquals(GANGSTA_TALK, gangstaSinger.sing());
    Singer emoSinger = Factory.convert(new EmoRapper());
    assertEquals(EMO_TALK, emoSinger.sing());
  }

  @Test
  public void testDancingRappers() {
    Singer boomBapSinger = Factory.convert(new BoomBapRapper());
    assertEquals(RAPPER_DANCE, boomBapSinger.dance());
    Singer gangstaSinger = Factory.convert(new GangstaRapper());
    assertEquals(RAPPER_DANCE, gangstaSinger.dance());
    Singer emoSinger = Factory.convert(new EmoRapper());
    assertEquals(RAPPER_DANCE, emoSinger.dance());
  }

  @Test
  public void testToStringRappers() {
    Singer boomBapSinger = Factory.convert(new BoomBapRapper());
    assertEquals("BoomBapRapper: " + BOOM_BAP_TALK, boomBapSinger.toString());
    Singer gangstaSinger = Factory.convert(new GangstaRapper());
    assertEquals("GangstaRapper: " + GANGSTA_TALK, gangstaSinger.toString());
    Singer emoSinger = Factory.convert(new EmoRapper());
    assertEquals("EmoRapper: " + EMO_TALK, emoSinger.toString());
  }

  @Test
  public void testOldAdapterDeleted() {
    String name = DidThatWorkTest.class.getPackageName() + ".Singing" + 'R' + "apperAdapter";
    try {
      Class.forName(name);
      fail("Class " + name + " should be deleted");
    } catch (ClassNotFoundException success) {
    }
  }

  @Test
  public void testAllMethodsHandled() {
    try {
      Factory.map(CharSequence.class, 42, Map.of());
      fail("Expected an UnhandledMethodException");
    } catch (UnhandledMethodException success) {
    }
  }

  @Test
  public void testMappingChainedInvocationHandlerParameters()
      throws NoSuchMethodException {
    try {
      new MappingChainedInvocationHandler(null, Map.of(), null);
      fail("Expected a NullPointerException for component==null");
    } catch (NullPointerException success) {
    }
    try {
      new MappingChainedInvocationHandler("Test", null, null);
      fail("Expected a NullPointerException for mapping==null");
    } catch (NullPointerException success) {
    }
    try {
      new MappingChainedInvocationHandler("Test",
          Map.of(Object.class.getMethod("wait"),
              Object.class.getMethod("wait", long.class)), null);
      fail("Expected IllegalArgumentException for mismatched parameter types");
    } catch (IllegalArgumentException success) {
    }
    try {
      new MappingChainedInvocationHandler("Test",
          Map.of(Object.class.getMethod("hashCode"),
              Object.class.getMethod("getClass")), null);
      fail("Expected IllegalArgumentException for mismatched return types");
    } catch (IllegalArgumentException success) {
    }
  }

  @Test
  public void testStructure() throws ReflectiveOperationException {
    test(Factory.convert(new BoomBapRapper()));
    test(Factory.convert(new GangstaRapper()));
    test(Factory.convert(new EmoRapper()));
  }

  private void test(Singer singer) throws ReflectiveOperationException {
    assertTrue("Singer needs to be a dynamic proxy instance",
        singer instanceof Proxy);

    assertTrue("Singer should use MappingHandler as InvocationHandler",
        InvocationHandlerExtractor.getInvocationHandler(singer) instanceof
            MappingHandler);
  }
}