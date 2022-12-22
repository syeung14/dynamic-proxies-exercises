/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch2.solution21;

import java.io.*;
import java.util.function.*;

public class Factory {
  private Factory() {}

  public static <K, V> CustomMap<K, V> createCustomMap() {
    return new CustomHashMap<>();
  }

  public static <K, V> CustomMap<K, V> createVirtualCustomMap() {
    Supplier<CustomMap<K, V>> supplier =
        (Supplier<CustomMap<K, V>> & Serializable) Factory::createCustomMap;

    return new VirtualCustomMap<>(supplier);
  }
}
