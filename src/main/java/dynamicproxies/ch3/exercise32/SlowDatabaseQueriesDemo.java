/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch3.exercise32;

import dynamicproxies.sql.*;
import dynamicproxies.util.measurement.*;

import java.io.*;
import java.sql.*;
import java.util.concurrent.*;

public class SlowDatabaseQueriesDemo {
  public static void main(String... args) throws SQLException, IOException {
    MeasurementAggregator measurements = new MeasurementAggregator();
    MeasurementPrinter printer = new MeasurementPrinter();
    TimeMeasuringDriver.init(
            // TODO: Use Factory.measureTime() to create a time measuring
            //   dynamic proxy of Connection instead, recursively proxying
            //   Connection, Statement, PreparedStatement, CallableStatement
            //   and ResultSet.
            ConnectionProxy::new,
        new TimeMeasuringHandler(
            new MeasurementComposite(printer, measurements),
            20, TimeUnit.MILLISECONDS
        )
    );
    DriverManager.drivers().forEach(System.out::println);
    new DatabaseHelper().runTest();
    System.out.println("10 Worst Queries");
    System.out.println("================");
    measurements.stream().limit(10).forEach(printer::accept);
  }
}