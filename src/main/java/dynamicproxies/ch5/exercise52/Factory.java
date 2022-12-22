/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch5.exercise52;

import java.util.*;

import static eu.javaspecialists.books.dynamicproxies.Proxies.*;

// DO NOT CHANGE
public class Factory {
  private Factory() {}
  public static <T> T adapt(Class<? super T> target,
                            Object... adapters) {
    Objects.requireNonNull(adapters, "adapters==null");
    for (int i = 0; i < adapters.length; i++) {
      Objects.requireNonNull(adapters[i], "adapters[" + i + "]==null");
    }
    return castProxy(target,
        new MultipleInheritanceHandler(target, adapters));
  }
}
