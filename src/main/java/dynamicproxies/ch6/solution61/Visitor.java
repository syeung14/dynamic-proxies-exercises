/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch6.solution61;

// DO NOT CHANGE
public interface Visitor {
  void visit(Word w);
  void visit(Punctuation p);
  void visit(Chapter c);
  void visit(Paragraph p);
  void visit(Sentence s);
}
