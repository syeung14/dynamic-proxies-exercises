/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch3.exercise31;

import eu.javaspecialists.books.dynamicproxies.*;

import java.io.*;
import java.util.*;

// DO NOT CHANGE
public class ReadDemo {
  public static void main(String... args) throws IOException,
                                                     ClassNotFoundException {
    // create other proxies first to make sure it's a different
    // class name this time
    Iterable<?> it = Proxies.virtualProxy(Iterable.class, HashSet::new);
    Collection<?> col = Proxies.virtualProxy(Collection.class, LinkedList::new);
    System.out.println(it.getClass());
    System.out.println(col.getClass());
    try (ObjectInputStream in =
             new ObjectInputStream(
                 new BufferedInputStream(
                     new FileInputStream("map.ser")))) {
      CustomMap<Integer, Integer> squares1 =
          (CustomMap<Integer, Integer>) in.readObject();
      CustomMap<Integer, Integer> squares2 =
          (CustomMap<Integer, Integer>) in.readObject();
      System.out.println("squares1 = " + squares1);
      System.out.println("squares2 = " + squares2);
      if (!squares1.equals(squares2)) throw new AssertionError();
      if (!squares2.equals(squares1)) throw new AssertionError();
      System.out.println("squares1.getClass() = " + squares1.getClass());
      System.out.println("squares2.getClass() = " + squares2.getClass());
    } catch(FileNotFoundException ex) {
      System.err.println("File not found - please run WriteDemo first.");
    }
  }
}
