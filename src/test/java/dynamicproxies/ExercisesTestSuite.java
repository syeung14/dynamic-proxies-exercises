/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies;

import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Suite.*;

// Run this test suite, with the following to the VM options:
// --add-reads eu.javaspecialists.books.dynamicproxies=eu.javaspecialists.courses.dynamicproxies
// --add-opens java.base/java.lang=eu.javaspecialists.books.dynamicproxies
@RunWith(Suite.class)
@SuiteClasses({
    dynamicproxies.ch2.exercise21.DidThatWorkTest.class,
    dynamicproxies.ch2.exercise22.DidThatWorkTest.class,
    dynamicproxies.ch3.exercise31.DidThatWorkTest.class,
    dynamicproxies.ch3.exercise32.DidThatWorkTest.class,
    dynamicproxies.ch4.exercise41.DidThatWorkTest.class,
    dynamicproxies.ch4.exercise42.DidThatWorkTest.class,
    dynamicproxies.ch5.exercise51.DidThatWorkTest.class,
    dynamicproxies.ch5.exercise52.DidThatWorkTest.class,
    dynamicproxies.ch5.exercise53.DidThatWorkTest.class,
    dynamicproxies.ch6.exercise61.DidThatWorkTest.class,
    dynamicproxies.ch6.exercise62.DidThatWorkTest.class,
})
public class ExercisesTestSuite {
  // this class is intentionally empty
}