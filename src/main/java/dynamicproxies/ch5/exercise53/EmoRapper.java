/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.exercise53;

// DO NOT CHANGE
public class EmoRapper implements Rapper {
  public String talk() {
    // Juice WRLD - Lucid Dreams Lyrics (Forget Me)
    return "I still see your shadows in my room";
  }
  public String toString() {
    return "EmoRapper: " + talk();
  }
}