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
public class Paragraph implements Element {
  private final Collection<Sentence> sentences =
      new ArrayList<>();

  public boolean add(Sentence sentence) {
    return this.sentences.add(sentence);
  }

  public boolean remove(Sentence sentence) {
    return this.sentences.remove(sentence);
  }

  public void accept(Visitor v) {
    v.visit(this);
    for (Sentence sentence : sentences) {
      sentence.accept(v);
    }
  }
}