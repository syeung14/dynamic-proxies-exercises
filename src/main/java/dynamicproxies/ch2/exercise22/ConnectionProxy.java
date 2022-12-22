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

// TODO: This class must implement Connection
// TODO: Use the TimeMeasuringHandler to record the time taken for all
// TODO: methods called 'createStatement', 'prepareStatement' and 'close'
// TODO: Take care when methods return values that also need to be proxied
public class ConnectionProxy {

  public ConnectionProxy(Connection connection, TimeMeasuringHandler handler) {
  }

  public Statement createStatement(
      int resultSetType, int resultSetConcurrency,
      int resultSetHoldability) throws SQLException {
    /*
      e.g.:
    try (var measurer = handler.start("java.sql.Connection",
        "createStatement", resultSetType, resultSetConcurrency,
        resultSetHoldability)) {
      return new StatementProxy(connection.createStatement(resultSetType,
          resultSetConcurrency, resultSetHoldability), handler);
     }
     */
    throw new UnsupportedOperationException("TODO");
  }
}