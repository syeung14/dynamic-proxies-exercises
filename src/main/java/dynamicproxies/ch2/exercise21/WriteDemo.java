/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch2.exercise21;

import java.io.*;

// DO NOT CHANGE
public class WriteDemo {
  public static void main(String... args) throws IOException {
    try (ObjectOutputStream out =
             new ObjectOutputStream(
                 new BufferedOutputStream(
                     new FileOutputStream("map.ser")))) {
      CustomMap<Integer, Integer> squares1 = Factory.createCustomMap();
      CustomMap<Integer, Integer> squares2 = Factory.createVirtualCustomMap();
      for (int i = 1; i <= 10; i++) {
        squares1.put(i, i * i);
        squares2.put(i, i * i);
      }
      out.writeObject(squares1);
      out.writeObject(squares2);
      System.out.println("squares1.getClass() = " + squares1.getClass());
      System.out.println("squares2.getClass() = " + squares2.getClass());
    }
  }
}
