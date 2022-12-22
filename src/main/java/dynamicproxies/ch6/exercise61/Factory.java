/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch6.exercise61;

// TODO: Return dynamic composites for each type
public class Factory {
  private Factory() {}

  public static Chapter createChapter() {
    return new Chapter();
  }

  public static Paragraph createParagraph() {
    return new Paragraph();
  }

  public static Sentence createSentence() {
    return new Sentence();
  }
}