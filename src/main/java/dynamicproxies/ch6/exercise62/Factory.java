/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch6.exercise62;

import java.util.function.*;

public class Factory {
  private Factory() {}

  // TODO: Change this to return a dynamic composite of consumers.
  //  (Hint: You will need another interface to use as CompositeConsumer.)
  public static<T> Consumer<T> compose(Consumer<? super T>... children) {
    Consumer<T> composite = t -> {};
    for (Consumer<? super T> child : children) {
      composite = composite.andThen(child);
    }
    return composite;
  }
}
