/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch2.exercise21;

public class Factory {
  private Factory() {}

  public static <K, V> CustomMap<K, V> createCustomMap() {
    // TODO: Implement to return a concrete type of CustomMap
    throw new UnsupportedOperationException("TODO");
  }

  public static <K, V> CustomMap<K, V> createVirtualCustomMap() {
    // TODO: Return a hand-crafted virtual proxy of CustomMap
    // TODO: Make sure that the Supplier also implements Serializable
    //   (Hint: have a look at how Comparator.comparingInt() creates a lambda
    //    that is both a Comparator and Serializable)
    throw new UnsupportedOperationException("TODO");
  }
}
