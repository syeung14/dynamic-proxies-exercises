/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies;

import dynamicproxies.util.measurement.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Suite.*;

// To run this test suite, either run `mvn test`
// or add the following to the VM options:
// --add-reads eu.javaspecialists.books.dynamicproxies=eu.javaspecialists.courses.dynamicproxies
// --add-opens java.base/java.lang=eu.javaspecialists.books.dynamicproxies
@RunWith(Suite.class)
@SuiteClasses({
    dynamicproxies.ch2.solution21.DidThatWorkTest.class,
    dynamicproxies.ch2.solution22.DidThatWorkTest.class,
    dynamicproxies.ch3.solution31.DidThatWorkTest.class,
    dynamicproxies.ch3.solution32.DidThatWorkTest.class,
    dynamicproxies.ch4.solution41.DidThatWorkTest.class,
    dynamicproxies.ch4.solution42.DidThatWorkTest.class,
    dynamicproxies.ch5.solution51.DidThatWorkTest.class,
    dynamicproxies.ch5.solution52.DidThatWorkTest.class,
    dynamicproxies.ch5.solution53.DidThatWorkTest.class,
    dynamicproxies.ch6.solution61.DidThatWorkTest.class,
    dynamicproxies.ch6.solution62.DidThatWorkTest.class,
    TimeMeasuringHandlerTest.class
})
public class SolutionsTestSuite {
  // this class is intentionally empty
}