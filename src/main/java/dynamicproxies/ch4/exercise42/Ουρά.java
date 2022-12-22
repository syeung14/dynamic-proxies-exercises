/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch4.exercise42;

// "Urá" - Greek for queue or tail
// Don't say "Úra" by mistake! (hint: urologist ...)
// DO NOT CHANGE
public interface Ουρά<E> {
  boolean offer(E e);
  E remove();
  E poll();
  E element();
  E peek();
  boolean isEmpty();
}