/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.exercise53;

// DO NOT CHANGE
public class BoomBapRapper implements Rapper {
  public String talk() {
    // EPMD - Da Joint
    return "I make a million buck / Every six months and y'all";
  }
  public String toString() {
    return "BoomBapRapper: " + talk();
  }
}