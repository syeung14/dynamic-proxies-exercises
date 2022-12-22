/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.util.measurement;

import java.lang.reflect.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class MeasurementPrinter implements Consumer<Measurement> {
  @Override
  public void accept(Measurement m) {
    System.out.printf("%s took %s%n",
        toString(m.className(), m.methodName(), m.parameters()),
        timeFormatter(m.nanos()));
  }

  private String toString(String className, String methodName, Object[] args) {
    return String.format(Locale.US,
        "%s.%s(%s)",
        className,
        methodName,
        args == null ? "" :
            Stream.of(args).map(this::toString)
                .collect(Collectors.joining(", ")));
  }

  private String toString(Object arg) {
    if (arg == null) return "null";
    if (arg.getClass().isArray()) {
      var result = new StringBuilder("[");
      for (int i = 0, length = Array.getLength(arg); i < length; i++) {
        result.append(toString(Array.get(arg, i)));
        if (i < length - 1) result.append(", ");
      }
      result.append("]");
      return result.toString();
    }
    return arg.toString();
  }

  private String timeFormatter(long nanos) {
    if (nanos < 10_000L) {
      return nanos + " nanoseconds";
    } else if (nanos < 10_000_000L) {
      return nanos / 1000L + " microseconds";
    } else if (nanos < 10_000_000_000L) {
      return nanos / 1_000_000L + " milliseconds";
    } else return nanos / 1_000_000_000L + " seconds";
  }
}