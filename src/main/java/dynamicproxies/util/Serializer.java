/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.util;

import java.io.*;

public class Serializer {
  public static <T> T serializeDeserialize(T t) {
    try {
      var baos = new ByteArrayOutputStream();
      try (var out = new ObjectOutputStream(baos)) {
        out.writeObject(t);
      }
      System.out.println(new String(baos.toByteArray()));
      try (var in = new ObjectInputStream(
          new ByteArrayInputStream(baos.toByteArray()))) {
        return (T) in.readObject();
      }
    } catch (IOException | ClassNotFoundException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
