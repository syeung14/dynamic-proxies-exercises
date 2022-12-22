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
import java.util.concurrent.atomic.*;
import java.util.function.*;
import java.util.stream.*;

public class MeasurementAggregator implements Consumer<Measurement> {
  private final AtomicLong nextOrder = new AtomicLong();

  private class MeasurementKey implements Comparable<MeasurementKey> {
    private final long order = nextOrder.incrementAndGet();
    private final Measurement measurement;
    public MeasurementKey(Measurement measurement) {
      this.measurement = measurement;
    }
    private Measurement getMeasurement() { return measurement; }

    @Override
    public int compareTo(MeasurementKey that) {
      int result = -Long.compare(measurement.nanos(), that.measurement.nanos());
      if (result != 0) return result;
      return Long.compare(order, that.order);
    }
  }

  private final Collection<MeasurementKey> measurements =
      new ConcurrentSkipListSet<>();

  @Override
  public void accept(Measurement measurement) {
    measurements.add(new MeasurementKey(measurement));
  }

  public Stream<Measurement> stream() {
    return measurements.stream().map(key -> key.measurement);
  }
}