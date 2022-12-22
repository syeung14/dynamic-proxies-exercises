/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch6.solution61;

import eu.javaspecialists.books.dynamicproxies.*;

public class Factory {
  private Factory() {}

  public static Chapter createChapter() {
    return Proxies.compose(Chapter.class, Paragraph.class);
  }

  public static Paragraph createParagraph() {
    return Proxies.compose(Paragraph.class, Sentence.class);
  }

  public static Sentence createSentence() {
    return Proxies.compose(Sentence.class, Token.class);
  }
}