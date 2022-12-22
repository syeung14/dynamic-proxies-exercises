/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch6.solution62;

import eu.javaspecialists.books.dynamicproxies.*;

import java.util.function.*;

public class Factory {
  private Factory() {}

  public static<T> Consumer<T> compose(Consumer<? super T>... children) {
    CompositeConsumer<T> composite = Proxies.compose(CompositeConsumer.class,
        Consumer.class);
    for (Consumer<? super T> child : children) {
      composite.add(child::accept);
    }
    return composite;
  }
}
