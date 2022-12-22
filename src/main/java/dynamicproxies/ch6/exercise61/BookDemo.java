/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch6.exercise61;

// To run this demo, the following must be added to the VM options:
// --add-reads eu.javaspecialists.books.dynamicproxies=eu.javaspecialists.courses.dynamicproxies
// DO NOT CHANGE
public class BookDemo {
  public static void main(String... args) {
    Chapter ch1 = Factory.createChapter();
    Paragraph p1 = Factory.createParagraph();
    ch1.add(p1);

    Sentence s1 = Factory.createSentence();
    p1.add(s1);
    s1.add(new Word("It"));
    s1.add(new Word("was"));
    s1.add(new Word("a"));
    s1.add(new Word("dark"));
    s1.add(new Word("and"));
    s1.add(new Word("stormy"));
    s1.add(new Word("night"));
    s1.add(new Punctuation('.'));

    Sentence s2 = Factory.createSentence();
    p1.add(s2);
    s2.add(new Word("No"));
    s2.add(new Word("one"));
    s2.add(new Word("was"));
    s2.add(new Word("moving"));
    s2.add(new Punctuation(','));
    s2.add(new Word("not"));
    s2.add(new Word("even"));
    s2.add(new Word("a"));
    s2.add(new Word("mouse"));
    s2.add(new Punctuation('.'));

    Paragraph p2 = Factory.createParagraph();
    ch1.add(p2);
    Sentence s3 = Factory.createSentence();
    p2.add(s3);
    s3.add(new Word("Suddenly"));
    s3.add(new Punctuation(','));
    s3.add(new Word("nothing"));
    s3.add(new Word("happened"));
    s3.add(new Punctuation('!'));

    Paragraph p3 = Factory.createParagraph();
    ch1.add(p3);
    Sentence s4 = Factory.createSentence();
    p3.add(s4);
    s4.add(new Word("The"));
    s4.add(new Word("End"));

    ch1.accept(new BookDebug());
    System.out.println();
    BookBuilder builder = new BookBuilder();
    ch1.accept(builder);
    System.out.println("{" + builder.value() + "}");
  }
}
