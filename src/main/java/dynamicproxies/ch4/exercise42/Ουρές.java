/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch4.exercise42;

import eu.javaspecialists.books.dynamicproxies.*;

import java.util.*;
import java.util.function.*;

// SEE README.txt for overview
public class Ουρές {
  public static <E> Ουρά<E> create(Supplier<Queue<E>> supplier) {
    // TODO Use own FilterHandlerWithStandardObjectMethods instead of the
    //    FilterHandler from the book
    return Proxies.filter(Ουρά.class, supplier.get());
  }
}