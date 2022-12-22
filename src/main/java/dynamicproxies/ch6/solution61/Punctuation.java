/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch6.solution61;

// DO NOT CHANGE
public class Punctuation implements Token {
  private final char value;

  public Punctuation(char value) {
    switch (value) {
      case '.':
      case ',':
      case '!':
      case '?':
        break;
      default:
        throw new IllegalArgumentException("Punctuation not supported: " + value);
    }
    this.value = value;
  }

  @Override
  public String toString() {
    return value();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Punctuation that = (Punctuation) o;
    return this.value == that.value;
  }

  @Override
  public int hashCode() {
    return value;
  }

  public String value() {
    return "" + value;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}