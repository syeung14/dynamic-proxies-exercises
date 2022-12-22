/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch6.solution61;

// DO NOT CHANGE
public class BookDebug implements Visitor {
  public void visit(Chapter c) {
    System.out.println("Chapter");
  }
  public void visit(Paragraph p) {
    System.out.println("\tParagraph");
  }
  public void visit(Sentence s) {
    System.out.println("\t\tSentence");
  }
  public void visit(Word w) {
    System.out.println("\t\t\tWord");
  }
  public void visit(Punctuation p) {
    System.out.println("\t\t\tPunctuation");
  }
}