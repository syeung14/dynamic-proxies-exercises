/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.solution52;

// DO NOT CHANGE
public interface All {
  String foo();
  String bar();
  String baz();
  String happy();
  String feet();
  default String mashup() {
    return foo() + bar() + baz() + happy() + feet();
  }
}