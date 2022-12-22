/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.util.measurement;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class TimeMeasuringHandler {
  private final long thresholdInNanos;
  private final Consumer<Measurement> handler;

  public TimeMeasuringHandler(Consumer<Measurement> handler, long threshold,
                              TimeUnit unit) {
    this.handler = handler;
    this.thresholdInNanos = unit.toNanos(threshold);
  }

  public Measurer start(String className, String methodName,
                        Object... parameters) {
    return new Measurer(className, methodName, parameters);
  }

  public class Measurer implements AutoCloseable {
    private final long start = System.nanoTime();
    private final String className;
    private final String methodName;
    private final Object[] parameters;
    private Measurer(String className, String methodName, Object[] parameters) {
      this.className = className;
      this.methodName = methodName;
      this.parameters = parameters;
    }
    @Override
    public void close() {
      long nanos = System.nanoTime() - start;
      if (nanos > thresholdInNanos) {
        handler.accept(
            new MeasurementImpl(className, methodName, parameters, nanos));
      }
    }
  }

  // perfect for Java 14-preview record
  private class MeasurementImpl implements Measurement {
    private final String className;
    private final String methodName;
    private final Object[] parameters;
    private final long nanos;

    private MeasurementImpl(String className, String methodName,
                            Object[] parameters, long nanos) {
      this.className = className;
      this.methodName = methodName;
      this.parameters = parameters;
      this.nanos = nanos;
    }

    @Override
    public String className() {
      return className;
    }
    @Override
    public String methodName() {
      return methodName;
    }
    @Override
    public Object[] parameters() {
      return parameters;
    }
    @Override
    public long nanos() {
      return nanos;
    }
  }
}