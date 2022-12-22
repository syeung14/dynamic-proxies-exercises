/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.exercise53;

// TODO: Delete
public class SingingRapperAdapter {
  private final Rapper rapper;
  public SingingRapperAdapter(Rapper rapper) {
    this.rapper = rapper;
  }
  public String sing() {
    return rapper.talk();
  }
}