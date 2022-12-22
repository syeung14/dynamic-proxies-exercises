/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch3.exercise32;

import dynamicproxies.util.measurement.*;

import java.util.*;

/**
 * Facade for all our dynamic proxies in this exercise.
 */
public class Factory {
  private Factory() {}
  public static <S> S measureTime(Class<? super S> intf,
                                  S instance,
                                  TimeMeasuringHandler handler,
                                  Class<?>... returnTypesToRecursivelyProxy) {
    return measureTime(intf, instance, handler,
        Set.of(returnTypesToRecursivelyProxy));
  }
  public static <S> S measureTime(Class<? super S> intf,
                                  S instance,
                                  TimeMeasuringHandler handler,
                                  Set<Class<?>> returnTypesToRecursivelyProxy) {
    // TODO: ... make a new proxy
    throw new UnsupportedOperationException("TODO");
  }
}