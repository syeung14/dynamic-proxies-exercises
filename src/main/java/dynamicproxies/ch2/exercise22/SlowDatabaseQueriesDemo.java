/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch2.exercise22;

import dynamicproxies.sql.*;
import dynamicproxies.util.measurement.*;

import java.io.*;
import java.sql.*;

public class SlowDatabaseQueriesDemo {
  public static void main(String... args) throws SQLException, IOException {
    MeasurementAggregator measurements = new MeasurementAggregator();
    MeasurementPrinter printer = new MeasurementPrinter();
    // TODO: Uncomment the following statement when the proxies are passing
    // TODO: their tests, then run this class
    // TODO: Experiment with the threshold time to limit excessive logging
    //    TimeMeasuringDriver.init(
    //        ConnectionProxy::new,
    //        new TimeMeasuringHandler(
    //            new MeasurementComposite(printer, measurements),
    //            1, TimeUnit.NANOSECONDS
    //        )
    //    );
    DriverManager.drivers().forEach(System.out::println);
    new DatabaseHelper().runTest();
    System.out.println("10 Worst Queries");
    System.out.println("================");
    // TODO: Print the 10 worst queries
  }
}