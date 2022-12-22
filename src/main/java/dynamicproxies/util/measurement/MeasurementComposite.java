/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.util.measurement;

import java.util.*;
import java.util.function.*;

public class MeasurementComposite implements Consumer<Measurement> {
  private final Collection<Consumer<? super Measurement>> consumers;

  @SafeVarargs
  public MeasurementComposite(Consumer<? super Measurement>... consumers) {
    this.consumers = List.of(consumers);
  }

  @Override
  public void accept(Measurement measurement) {
    consumers.forEach(consumer -> consumer.accept(measurement));
  }
}