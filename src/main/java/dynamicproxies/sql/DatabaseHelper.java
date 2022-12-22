/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.sql;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.sql.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class DatabaseHelper {
  private static final String JDBC_PROTOCOL = "jdbc:derby:memory:";
  private static final String DB_NAME = "derbydb";
  private static final int ROWS_PER_TABLE = 500_000;

  public void runTest() throws SQLException, IOException {
    try (Connection connection = getConnection()) {
      System.out.println("Creating tables . . .");
      createTables(connection);

      System.out.println("Adding data . . .");
      addData(connection);

      System.out.println("Retrieving data . . .");
      loadData(connection, "SELECT A_ID, A_NAME, A_DESC FROM A", 3);
      loadData(connection, "SELECT B_ID, A_ID, B_NAME FROM B", 3);
      loadData(connection,
          "SELECT A_NAME, A_DESC, B_NAME FROM A JOIN B ON A.A_ID=B.A_ID", 3);
      loadData(connection,
          "SELECT A_NAME, A_DESC, B_NAME FROM A JOIN B ON A.A_DESC=B.B_NAME",
          3);
    } finally {
      System.out.println("Shutdown . . .");
      shutdownDatabase();
    }
  }

  private Connection getConnection() throws SQLException {
    String connectionUrl = JDBC_PROTOCOL + DB_NAME + ";create=true";
    return DriverManager.getConnection(connectionUrl);
  }

  private void shutdownDatabase() {
    String connectionUrl = JDBC_PROTOCOL + DB_NAME + ";shutdown=true";
    try {
      DriverManager.getConnection(connectionUrl);
    } catch (SQLException e) {
      // Error 08006 is expected when shutting down a single Derby database
      if (!e.getSQLState().equals("08006")) {
        e.printStackTrace();
      }
    }
  }

  private void createTables(Connection connection) throws SQLException,
                                                              IOException {
    String[] sqlCommands = getSqlCommands("schema.sql");
    for (String sqlCommand : sqlCommands) {
      try (Statement createTable = connection.createStatement()) {
        // Change to a single line for better logging
        String oneLineSqlCommand = sqlCommand.replaceAll("\n", " ").trim();
        if (!oneLineSqlCommand.isEmpty()) {
          createTable.execute(oneLineSqlCommand);
        }
      }
    }
  }

  private String[] getSqlCommands(String name) throws IOException {
    URL resource = getClass().getResource(name);
    Path path = new File(URLDecoder.decode(resource.getFile(), "UTF-8")).toPath();
    return new String(Files.readAllBytes(path))
               .replaceAll("\\/\\*\\X*\\*\\/", "")  // Remove block comments
               .split(";");
  }

  private void addData(Connection connection) throws SQLException, IOException {
    String[] sqlCommands = getSqlCommands("data.sql");
    for (String sqlCommand : sqlCommands) {
      // Change to a single line for better logging
      String oneLineSqlCommand = sqlCommand.replaceAll("\n", " ").trim();
      if (!oneLineSqlCommand.isEmpty()) {
        // Count how many parameters are needed
        int numberOfParameters = (int) oneLineSqlCommand.chars()
                                           .filter(ch -> ch == '?').count();
        try (PreparedStatement putData =
                 connection.prepareStatement(oneLineSqlCommand)) {
          if (numberOfParameters == 0) {
            putData.executeUpdate();
          } else {
            for (int row = 0; row < ROWS_PER_TABLE; row++) {
              for (int i = 0; i < numberOfParameters; i++) {
                putData.setObject(i + 1, randomString());
              }
              putData.addBatch();
            }
            putData.executeBatch();
          }
        }
      }
    }
  }

  private String randomString() {
    return ThreadLocalRandom.current().ints(32, 0, 26)
               .mapToObj(n -> (char) ('a' + n))
               .collect(Collector.of(
                   StringBuilder::new,
                   StringBuilder::append,
                   StringBuilder::append,
                   StringBuilder::toString));
  }

  private void loadData(Connection connection, String sql,
                        int outputCount) throws SQLException {
    try (Statement fetchData = connection.createStatement();
         ResultSet rs = fetchData.executeQuery(sql)) {
      System.out.println("First 5 rows of output of " + sql);
      int count = 0;
      while (rs.next() && count++ < 5) {
        for (int i = 0; i < outputCount; i++) {
          System.out.print(rs.getObject(i + 1) + "\t");
        }
        System.out.println();
      }
    }
  }
}
