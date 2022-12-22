/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch3.solution32;

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
        (connection, timeMeasuringHandler) ->
            Factory.measureTime(Connection.class,
                connection, timeMeasuringHandler,
                Connection.class, Statement.class, PreparedStatement.class,
                CallableStatement.class, ResultSet.class),
        new TimeMeasuringHandler(
            new MeasurementComposite(printer, measurements),
            1, TimeUnit.MILLISECONDS
        )
    );
    new DatabaseHelper().runTest();
    System.out.println("10 Worst Queries");
    System.out.println("================");
    measurements.stream().limit(10).forEach(printer::accept);
  }
}