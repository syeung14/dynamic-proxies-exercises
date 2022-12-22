/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.util.measurement;

import java.sql.*;
import java.util.*;
import java.util.function.*;
import java.util.logging.*;
import java.util.stream.*;

public class TimeMeasuringDriver implements Driver {
  private static BiFunction<Connection, TimeMeasuringHandler, Connection>
      proxier = (c, t) -> c; // no proxy by default
  private static TimeMeasuringHandler handler;

  /**
   * These values could also be set via system properties
   */
  public static void init(
      BiFunction<Connection, TimeMeasuringHandler, Connection> proxier,
      TimeMeasuringHandler handler) {
    TimeMeasuringDriver.proxier = proxier;
    TimeMeasuringDriver.handler = handler;
  }

  static {
    System.out.println("TimeMeasuringDriver injected");
    Collection<Driver> drivers =
        DriverManager.drivers().collect(Collectors.toList());
    DriverManager.drivers().forEach(driver -> {
      try {
        DriverManager.deregisterDriver(driver);
      } catch (SQLException e) {
        throw new Error(e);
      }
    });
    try {
      DriverManager.registerDriver(new TimeMeasuringDriver());
      for (Driver driver : drivers) {
        DriverManager.registerDriver(driver);
      }
    } catch (SQLException e) {
      throw new Error(e);
    }
  }

  @Override
  public boolean acceptsURL(String url) throws SQLException {
    return true;
  }

  @Override
  public Connection connect(String url, Properties info) throws SQLException {
    SQLException reason = null;
    Enumeration<Driver> en = DriverManager.getDrivers();
    while (en.hasMoreElements()) {
      Driver driver = (Driver) en.nextElement();
      if (!(driver instanceof TimeMeasuringDriver)) {
        try {
          Connection result = driver.connect(url, info);
          if (result != null) {
            // Success!
            return proxier.apply(result, handler);
          }
        } catch (SQLException ex) {
          reason = ex;
        }
      }
    }
    // if we got here nobody could connect.
    if (reason != null) {
      throw reason;
    }
    throw new SQLException(
        "No suitable driver found for " + url, "08001");
  }
  @Override
  public DriverPropertyInfo[] getPropertyInfo(
      String url, Properties info) throws SQLException {
    return new DriverPropertyInfo[0];
  }
  @Override
  public int getMajorVersion() {
    return 0;
  }
  @Override
  public int getMinorVersion() {
    return 1;
  }
  @Override
  public boolean jdbcCompliant() {
    return true;
  }
  @Override
  public Logger getParentLogger() throws SQLFeatureNotSupportedException {
    throw new SQLFeatureNotSupportedException();
  }
}