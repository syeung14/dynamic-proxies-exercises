/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.solution53;

// DO NOT CHANGE
public class GangstaRapper implements Rapper {
  public String talk() {
    // Kool Savas - Keep it Gangsta
    return "Ich hör', was ich will, ich Keep it Gangsta und";
  }
  public String toString() {
    return "GangstaRapper: " + talk();
  }
}