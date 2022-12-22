/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch2.exercise22;

import dynamicproxies.util.measurement.*;

import java.sql.*;

// TODO: This class must implement Statement
// TODO: Use the TimeMeasuringHandler to record the time taken for all
// TODO: methods with 'execute' in the name, and the 'close' method
public class StatementProxy {

  public StatementProxy(Statement statement, TimeMeasuringHandler handler) {
  }

  public boolean execute(String sql) throws SQLException {
     /*
      e.g.
      try (var measurer = handler.start("java.sql.Statement", "execute", sql)) {
        return statement.execute(sql);
      }
     */
    throw new UnsupportedOperationException("TODO");
  }
}