/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch6.solution61;

import java.util.*;

// DO NOT CHANGE
public class Word implements Token {
  private final String value;

  public Word(String value) {
    if (value.matches(".*[ \\.,!?].*"))
      throw new IllegalArgumentException("Word may not contain space or .,?!");
    this.value = Objects.requireNonNull(value, "value==null");
  }

  @Override
  public String toString() {
    return value();
  }

  public String value() {
    return value;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}