/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.util.measurement;

import org.junit.*;

import java.util.concurrent.*;

import static org.junit.Assert.*;

public class TimeMeasuringHandlerTest {
  private TimeMeasuringHandler handler;
  private String spiedClassName;
  private String spiedMethodName;
  private Object[] spiedArguments;
  private long spiedNanos;

  @Before
  public void setUp() throws Exception {
    handler = new TimeMeasuringHandler(
        m -> {
          spiedClassName = m.className();
          spiedMethodName = m.methodName();
          spiedArguments = m.parameters();
          spiedNanos = m.nanos();
        },
        1, TimeUnit.NANOSECONDS);
  }

  @Test
  public void testHandlerAcceptIsCalled() {
    String testClassName = "java.lang.String";
    String testMethodName = "indexOf";
    Object[] testArguments = new Object[] {"J"};
    try (var measurer = handler.start(testClassName, testMethodName,
        testArguments)) {
      "The JavaSpecialists Newsletter".indexOf("J");
    } finally {
      assertEquals(testClassName, spiedClassName);
      assertEquals(testMethodName, spiedMethodName);
      assertArrayEquals(testArguments, spiedArguments);
      assertTrue(spiedNanos > 0);
    }
  }
}