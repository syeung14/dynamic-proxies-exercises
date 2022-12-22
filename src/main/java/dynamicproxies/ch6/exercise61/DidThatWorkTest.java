/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch6.exercise61;

import org.junit.*;

import java.lang.reflect.*;

import static org.junit.Assert.*;

// To run this test, the following must be added to the VM options:
// --add-reads eu.javaspecialists.books.dynamicproxies=eu.javaspecialists.courses.dynamicproxies
public class DidThatWorkTest {
  @Test
  public void testStructure() {
    assertTrue("Chapter instance should be a dynamic composite",
        ((Object)Factory.createChapter()) instanceof Proxy);
    assertTrue("Paragraph instance should be a dynamic composite",
        ((Object)Factory.createParagraph()) instanceof Proxy);
    assertTrue("Sentence instance should be a dynamic composite",
        ((Object)Factory.createSentence()) instanceof Proxy);

    assertTrue("Chapter should be an interface", Chapter.class.isInterface());
    assertTrue("Paragraph should be an interface", Paragraph.class.isInterface());
    assertTrue("Sentence should be an interface", Sentence.class.isInterface());
  }

  @Test
  public void testBadWord() {
    // no, not a "naughty" word
    try {
      new Word(null);
      fail("Expected NullPointerException");
    } catch (NullPointerException success) {
    }
    try {
      new Word("Hello,");
      fail("Expected IllegalArgumentException with a , in the word");
    } catch (IllegalArgumentException success) {
    }
    try {
      new Word("Hello?");
      fail("Expected IllegalArgumentException with a ? in the word");
    } catch (IllegalArgumentException success) {
    }
    try {
      new Word("Hello!");
      fail("Expected IllegalArgumentException with a ! in the word");
    } catch (IllegalArgumentException success) {
    }
    try {
      new Word("Hello.");
      fail("Expected IllegalArgumentException with a . in the word");
    } catch (IllegalArgumentException success) {
    }
  }

  @Test
  public void testBadPunctuation() {
    try {
      new Punctuation('a');
      fail("Expected IllegalArgumentException");
    } catch (IllegalArgumentException success) {
    }
    try {
      new Punctuation('\'');
      fail("Expected IllegalArgumentException with a ' as punctuation");
    } catch (IllegalArgumentException success) {
    }
    try {
      new Punctuation('\"');
      fail("Expected IllegalArgumentException with a ' as punctuation");
    } catch (IllegalArgumentException success) {
    }
    for (char c = 0; c < 256; c++) {
      if (c == '.' || c == ',' || c == '!' || c == '?') new Punctuation(c);
      else {
        try {
          new Punctuation(c);
          fail("Expected IllegalArgumentException with a " + c + " as punctuation");
        } catch (IllegalArgumentException success) {
        }
      }
    }
  }


  @Test
  public void testQuickBrownFox() {
    Sentence sentence = createQuickBrownFoxSentence();
    assertEquals("The quick brown fox jumps over the lazy dog.", toString(sentence));
  }

  @Test
  public void testMurderSheWrote() {
    Sentence sentence = createMurderSheWroteSentence();
    assertEquals("Murder, she wrote!!!",
        toString(sentence));
  }
  @Test
  public void testWhatThe() {
    Sentence sentence = createWhatTheSentence();
    assertEquals("What, the?!",
        toString(sentence));
  }

  @Test
  public void testParagraph() {
    Paragraph paragraph = Factory.createParagraph();
    paragraph.add(createQuickBrownFoxSentence());
    paragraph.add(createWhatTheSentence());
    assertEquals("The quick brown fox jumps over the lazy dog. What, the?!",
        toString(paragraph));
  }

  @Test
  public void testChapter() {
    Paragraph paragraph1 = Factory.createParagraph();
    paragraph1.add(createQuickBrownFoxSentence());
    paragraph1.add(createWhatTheSentence());
    Paragraph paragraph2 = Factory.createParagraph();
    paragraph2.add(createMurderSheWroteSentence());
    Chapter chapter = Factory.createChapter();
    chapter.add(paragraph1);
    chapter.add(paragraph2);
    assertEquals("The quick brown fox jumps over the lazy dog. What, the?!\n\nMurder, she wrote!!!",
        toString(chapter));
  }

  @Test
  public void testAddMethodsOnlyTakeCorrectTypes() throws ReflectiveOperationException {
    Chapter c = Factory.createChapter();
    tryAdd(Chapter.class, Chapter.class, c, Factory.createChapter());
    tryAdd(Chapter.class, Sentence.class, c, Factory.createSentence());
    tryAdd(Chapter.class, Word.class, c, new Word("Bananas"));

    Paragraph p = Factory.createParagraph();
    tryAdd(Paragraph.class, Chapter.class, p, Factory.createChapter());
    tryAdd(Paragraph.class, Paragraph.class, p, Factory.createParagraph());
    tryAdd(Paragraph.class, Word.class, p, new Word("Bananas"));

    Sentence s = Factory.createSentence();
    tryAdd(Sentence.class, Chapter.class, s, Factory.createChapter());
    tryAdd(Sentence.class, Paragraph.class, s, Factory.createParagraph());
    tryAdd(Sentence.class, Sentence.class, s, Factory.createSentence());
  }

  private void tryAdd(Class<?> clazz, Class<?> parameterType,
                      Object o1, Object o2) throws ReflectiveOperationException {
    try {
      Method add = findAddMethod(clazz);
      add.invoke(o1, o2);
      fail("Should not be able to add a " + parameterType.getSimpleName() +
               " into a " + clazz.getSimpleName());
    } catch (IllegalArgumentException success) {
    } catch (InvocationTargetException e) {
      try {
        throw e.getCause();
      } catch (ClassCastException success) {
      } catch (Throwable t) {
        fail("Unexcepted exception : " + t);
      }
    }
  }

  private Method findAddMethod(Class<?> clazz) throws NoSuchMethodException {
    for (Method method : clazz.getMethods()) {
      if (method.getName().equals("add")
              && method.getReturnType() == boolean.class
              && method.getParameterCount() == 1)
        return method;
    }
    throw new NoSuchMethodException("add");
  }

  private String toString(Element element) {
    BookBuilder builder = new BookBuilder();
    element.accept(builder);
    return builder.value();
  }

  private Sentence createQuickBrownFoxSentence() {
    Sentence sentence = Factory.createSentence();
    sentence.add(new Word("The"));
    sentence.add(new Word("quick"));
    sentence.add(new Word("brown"));
    sentence.add(new Word("fox"));
    sentence.add(new Word("jumps"));
    sentence.add(new Word("over"));
    sentence.add(new Word("the"));
    sentence.add(new Word("lazy"));
    sentence.add(new Word("dog"));
    sentence.add(new Punctuation('.'));
    return sentence;
  }
  private Sentence createMurderSheWroteSentence() {
    Sentence sentence = Factory.createSentence();
    sentence.add(new Word("Murder"));
    sentence.add(new Punctuation(','));
    sentence.add(new Word("she"));
    sentence.add(new Word("wrote"));
    sentence.add(new Punctuation('!'));
    sentence.add(new Punctuation('!'));
    sentence.add(new Punctuation('!'));
    return sentence;
  }
  private Sentence createWhatTheSentence() {
    Sentence sentence = Factory.createSentence();
    sentence.add(new Word("What"));
    sentence.add(new Punctuation(','));
    sentence.add(new Word("the"));
    sentence.add(new Punctuation('?'));
    sentence.add(new Punctuation('!'));
    return sentence;
  }

}