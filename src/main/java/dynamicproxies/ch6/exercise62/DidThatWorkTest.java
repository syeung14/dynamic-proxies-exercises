/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch6.exercise62;

import org.junit.*;

import java.lang.reflect.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;
import java.util.stream.*;

import static org.junit.Assert.*;

public class DidThatWorkTest {
  @Test
  public void testStructure() {
    Consumer<String> outErr =
        Factory.compose(System.out::println, System.err::println);

    assertTrue("Composite consumer should be a dynamic proxy",
        outErr instanceof Proxy);
  }
  @Test
  public void testCompositeSysOutErrPrintln() {
    Consumer<String> outErr =
        Factory.compose(System.out::println, System.err::println);
    Stream.of(("Goodbye cruel world, I'm leaving you today. " +
                   "Don't worry, be happy!")
                  .split(" ")).forEach(outErr);
  }
  @Test
  public void testCompositeSysOutErrPrintlnCounter() {
    Consumer<String> outErr =
        Factory.compose(System.out::println, System.err::println);
    LongAdder count = new LongAdder();
    Consumer<? super String> counters = o -> count.increment();
    Consumer<String> upperCasePrint = s -> System.out.println(s.toUpperCase());
    Consumer<String> all = Factory.compose(
        outErr, counters, upperCasePrint
    );
    Stream.of(("Goodbye cruel world, I'm leaving you today. " +
                   "Don't worry, be happy!")
                  .split(" ")).forEach(all);
    assertEquals(11, count.intValue());
  }
}
