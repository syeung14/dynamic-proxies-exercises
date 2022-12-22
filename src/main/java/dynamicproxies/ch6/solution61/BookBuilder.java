/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch6.solution61;

// DO NOT CHANGE
public class BookBuilder implements Visitor {
  private final StringBuilder sb = new StringBuilder();
  private boolean newChapter = false;
  private boolean newParagraph = false;
  private boolean newSentence = false;

  public void visit(Chapter c) {
    newChapter = true;
  }

  public void visit(Paragraph p) {
    newParagraph = true;
  }

  public void visit(Sentence s) {
    newSentence = true;
  }

  public void visit(Word w) {
    if (sb.length() != 0) {
      if (newChapter) {
        sb.append("\n\n--------\n\n");
      } else if (newParagraph) {
        sb.append("\n\n");
      } else if (newSentence) {
        sb.append(" ");
      } else {
        sb.append(" ");
      }
    }
    newChapter = newParagraph = newSentence = false;
    sb.append(w.value());
  }

  public void visit(Punctuation p) {
    sb.append(p.value());
  }

  public String value() {
    return sb.toString();
  }
}