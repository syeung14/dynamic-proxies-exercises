/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch6.exercise61;

import java.util.*;

// TODO: This should become an interface, with the accept() method remaining as
//  a default interface method, but not calling accept() on the paragraphs
//  (that is done by the dynamic composite)
public class Chapter implements Element {
  private final Collection<Paragraph> paragraphs =
      new ArrayList<>();

  public boolean add(Paragraph paragraph) {
    return this.paragraphs.add(paragraph);
  }

  public boolean remove(Paragraph paragraph) {
    return this.paragraphs.remove(paragraph);
  }

  public void accept(Visitor v) {
    v.visit(this);
    for (Paragraph paragraph : paragraphs) {
      paragraph.accept(v);
    }
  }
}
