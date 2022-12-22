/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch6.solution61;

import eu.javaspecialists.books.dynamicproxies.handlers.*;

public interface Element extends BaseComponent<Element> {
  void accept(Visitor v);
}
