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
public class Sentence implements Element {
  private final List<Token> tokens =
      new ArrayList<>();

  public boolean add(Token token) {
    return tokens.add(token);
  }

  public boolean remove(Token token) {
    return tokens.remove(token);
  }

  public void accept(Visitor v) {
    v.visit(this);
    for (Token token : tokens) {
      if (token instanceof Word) {
        ((Word) token).accept(v);
      } else if (token instanceof Punctuation) {
        ((Punctuation) token).accept(v);
      }
    }
  }
}
