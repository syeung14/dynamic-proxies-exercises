/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch3.exercise32;

import dynamicproxies.util.measurement.*;

import java.io.*;
import java.math.*;
import java.net.*;
import java.sql.Date;
import java.sql.*;
import java.util.*;

// TODO: Delete and replace with dynamic proxy
public class PreparedStatementProxy implements PreparedStatement {
  private final PreparedStatement preparedStatement;
  private final TimeMeasuringHandler handler;

  public PreparedStatementProxy(PreparedStatement preparedStatement, TimeMeasuringHandler handler) {
    this.preparedStatement = preparedStatement;
    this.handler = handler;
  }

  @Override
  public boolean execute() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "execute")) {
      return preparedStatement.execute();
    }
  }
  @Override
  public boolean execute(String sql) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "execute", sql)) {
      return preparedStatement.execute(sql);
    }
  }
  @Override
  public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "execute", sql, autoGeneratedKeys)) {
      return preparedStatement.execute(sql, autoGeneratedKeys);
    }
  }
  @Override
  public boolean execute(String sql, int[] columnIndexes) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "execute", sql, columnIndexes)) {
      return preparedStatement.execute(sql, columnIndexes);
    }
  }
  @Override
  public boolean execute(String sql, String[] columnNames) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "execute", sql, columnNames)) {
      return preparedStatement.execute(sql, columnNames);
    }
  }
  @Override
  public int[] executeBatch() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "executeBatch")) {
      return preparedStatement.executeBatch();
    }
  }
  @Override
  public long[] executeLargeBatch() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "executeLargeBatch")) {
      return preparedStatement.executeLargeBatch();
    }
  }
  @Override
  public long executeLargeUpdate() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "executeLargeUpdate")) {
      return preparedStatement.executeLargeUpdate();
    }
  }
  @Override
  public long executeLargeUpdate(String sql) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "executeLargeUpdate", sql)) {
      return preparedStatement.executeLargeUpdate(sql);
    }
  }
  @Override
  public long executeLargeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "executeLargeUpdate", sql, autoGeneratedKeys)) {
      return preparedStatement.executeLargeUpdate(sql, autoGeneratedKeys);
    }
  }
  @Override
  public long executeLargeUpdate(String sql, int[] columnIndexes) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "executeLargeUpdate", sql, columnIndexes)) {
      return preparedStatement.executeLargeUpdate(sql, columnIndexes);
    }
  }
  @Override
  public long executeLargeUpdate(String sql, String[] columnNames) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "executeLargeUpdate", sql, columnNames)) {
      return preparedStatement.executeLargeUpdate(sql, columnNames);
    }
  }
  @Override
  public ResultSet executeQuery() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "executeQuery")) {
      return preparedStatement.executeQuery();
    }
  }
  @Override
  public ResultSet executeQuery(String sql) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "executeQuery", sql)) {
      return preparedStatement.executeQuery(sql);
    }
  }
  @Override
  public int executeUpdate() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "executeUpdate")) {
      return preparedStatement.executeUpdate();
    }
  }
  @Override
  public int executeUpdate(String sql) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "executeUpdate", sql)) {
      return preparedStatement.executeUpdate(sql);
    }
  }
  @Override
  public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "executeUpdate", sql, autoGeneratedKeys)) {
      return preparedStatement.executeUpdate(sql, autoGeneratedKeys);
    }
  }
  @Override
  public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "executeUpdate", sql, columnIndexes)) {
      return preparedStatement.executeUpdate(sql, columnIndexes);
    }
  }
  @Override
  public int executeUpdate(String sql, String[] columnNames) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "executeUpdate", sql, columnNames)) {
      return preparedStatement.executeUpdate(sql, columnNames);
    }
  }
  @Override
  public void setObject(int parameterIndex, Object x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setObject", parameterIndex, x)) {
      preparedStatement.setObject(parameterIndex, x);
    }
  }
  @Override
  public void addBatch() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "addBatch")) {
      preparedStatement.addBatch();
    }
  }
  @Override
  public void close() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "close")) {
      preparedStatement.close();
    }
  }
  @Override
  public void setNull(int parameterIndex, int sqlType) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setNull", parameterIndex, sqlType)) {
      preparedStatement.setNull(parameterIndex, sqlType);
    }
  }
  @Override
  public void setBoolean(int parameterIndex, boolean x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setBoolean", parameterIndex, x)) {
      preparedStatement.setBoolean(parameterIndex, x);
    }
  }
  @Override
  public void setByte(int parameterIndex, byte x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setByte", parameterIndex, x)) {
      preparedStatement.setByte(parameterIndex, x);
    }
  }
  @Override
  public void setShort(int parameterIndex, short x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setShort", parameterIndex, x)) {
      preparedStatement.setShort(parameterIndex, x);
    }
  }
  @Override
  public void setInt(int parameterIndex, int x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setInt", parameterIndex, x)) {
      preparedStatement.setInt(parameterIndex, x);
    }
  }
  @Override
  public void setLong(int parameterIndex, long x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setLong", parameterIndex, x)) {
      preparedStatement.setLong(parameterIndex, x);
    }
  }
  @Override
  public void setFloat(int parameterIndex, float x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setFloat", parameterIndex, x)) {
      preparedStatement.setFloat(parameterIndex, x);
    }
  }
  @Override
  public void setDouble(int parameterIndex, double x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setDouble", parameterIndex, x)) {
      preparedStatement.setDouble(parameterIndex, x);
    }
  }
  @Override
  public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setBigDecimal", parameterIndex, x)) {
      preparedStatement.setBigDecimal(parameterIndex, x);
    }
  }
  @Override
  public void setString(int parameterIndex, String x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setString", parameterIndex, x)) {
      preparedStatement.setString(parameterIndex, x);
    }
  }
  @Override
  public void setBytes(int parameterIndex, byte[] x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setBytes", parameterIndex, x)) {
      preparedStatement.setBytes(parameterIndex, x);
    }
  }
  @Override
  public void setDate(int parameterIndex, Date x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setDate", parameterIndex, x)) {
      preparedStatement.setDate(parameterIndex, x);
    }
  }
  @Override
  public void setTime(int parameterIndex, Time x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setTime", parameterIndex, x)) {
      preparedStatement.setTime(parameterIndex, x);
    }
  }
  @Override
  public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setTimestamp", parameterIndex, x)) {
      preparedStatement.setTimestamp(parameterIndex, x);
    }
  }
  @Override
  public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setAsciiStream", parameterIndex, x, length)) {
      preparedStatement.setAsciiStream(parameterIndex, x, length);
    }
  }
  @Override
  @Deprecated(since = "1.2")
  public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setUnicodeStream", parameterIndex, x, length)) {
      preparedStatement.setUnicodeStream(parameterIndex, x, length);
    }
  }
  @Override
  public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setBinaryStream", parameterIndex, x, length)) {
      preparedStatement.setBinaryStream(parameterIndex, x, length);
    }
  }
  @Override
  public void clearParameters() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "clearParameters")) {
      preparedStatement.clearParameters();
    }
  }
  @Override
  public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setObject", parameterIndex, x, targetSqlType)) {
      preparedStatement.setObject(parameterIndex, x, targetSqlType);
    }
  }
  @Override
  public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setCharacterStream", parameterIndex, reader, length)) {
      preparedStatement.setCharacterStream(parameterIndex, reader, length);
    }
  }
  @Override
  public void setRef(int parameterIndex, Ref x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setRef", parameterIndex, x)) {
      preparedStatement.setRef(parameterIndex, x);
    }
  }
  @Override
  public void setBlob(int parameterIndex, Blob x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setBlob", parameterIndex, x)) {
      preparedStatement.setBlob(parameterIndex, x);
    }
  }
  @Override
  public void setClob(int parameterIndex, Clob x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setClob", parameterIndex, x)) {
      preparedStatement.setClob(parameterIndex, x);
    }
  }
  @Override
  public void setArray(int parameterIndex, Array x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setArray", parameterIndex, x)) {
      preparedStatement.setArray(parameterIndex, x);
    }
  }
  @Override
  public ResultSetMetaData getMetaData() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getMetaData")) {
      return preparedStatement.getMetaData();
    }
  }
  @Override
  public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setDate", parameterIndex, x, cal)) {
      preparedStatement.setDate(parameterIndex, x, cal);
    }
  }
  @Override
  public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setTime", parameterIndex, x, cal)) {
      preparedStatement.setTime(parameterIndex, x, cal);
    }
  }
  @Override
  public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setTimestamp", parameterIndex, x, cal)) {
      preparedStatement.setTimestamp(parameterIndex, x, cal);
    }
  }
  @Override
  public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setNull", parameterIndex, sqlType, typeName)) {
      preparedStatement.setNull(parameterIndex, sqlType, typeName);
    }
  }
  @Override
  public void setURL(int parameterIndex, URL x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setURL", parameterIndex, x)) {
      preparedStatement.setURL(parameterIndex, x);
    }
  }
  @Override
  public ParameterMetaData getParameterMetaData() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getParameterMetaData")) {
      return preparedStatement.getParameterMetaData();
    }
  }
  @Override
  public void setRowId(int parameterIndex, RowId x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setRowId", parameterIndex, x)) {
      preparedStatement.setRowId(parameterIndex, x);
    }
  }
  @Override
  public void setNString(int parameterIndex, String value) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setNString", parameterIndex, value)) {
      preparedStatement.setNString(parameterIndex, value);
    }
  }
  @Override
  public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setNCharacterStream", parameterIndex, value, length)) {
      preparedStatement.setNCharacterStream(parameterIndex, value, length);
    }
  }
  @Override
  public void setNClob(int parameterIndex, NClob value) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setNClob", parameterIndex, value)) {
      preparedStatement.setNClob(parameterIndex, value);
    }
  }
  @Override
  public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setClob", parameterIndex, reader, length)) {
      preparedStatement.setClob(parameterIndex, reader, length);
    }
  }
  @Override
  public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setBlob", parameterIndex, inputStream, length)) {
      preparedStatement.setBlob(parameterIndex, inputStream, length);
    }
  }
  @Override
  public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setNClob", parameterIndex, reader, length)) {
      preparedStatement.setNClob(parameterIndex, reader, length);
    }
  }
  @Override
  public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setSQLXML", parameterIndex, xmlObject)) {
      preparedStatement.setSQLXML(parameterIndex, xmlObject);
    }
  }
  @Override
  public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setObject", parameterIndex, x, targetSqlType,
        scaleOrLength)) {
      preparedStatement.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
    }
  }
  @Override
  public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setAsciiStream", parameterIndex, x, length)) {
      preparedStatement.setAsciiStream(parameterIndex, x, length);
    }
  }
  @Override
  public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setBinaryStream", parameterIndex, x, length)) {
      preparedStatement.setBinaryStream(parameterIndex, x, length);
    }
  }
  @Override
  public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setCharacterStream", parameterIndex, reader,
        length)) {
      preparedStatement.setCharacterStream(parameterIndex, reader, length);
    }
  }
  @Override
  public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setAsciiStream", parameterIndex, x)) {
      preparedStatement.setAsciiStream(parameterIndex, x);
    }
  }
  @Override
  public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setBinaryStream", parameterIndex, x)) {
      preparedStatement.setBinaryStream(parameterIndex, x);
    }
  }
  @Override
  public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setCharacterStream", parameterIndex, reader)) {
      preparedStatement.setCharacterStream(parameterIndex, reader);
    }
  }
  @Override
  public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setNCharacterStream", parameterIndex, value)) {
      preparedStatement.setNCharacterStream(parameterIndex, value);
    }
  }
  @Override
  public void setClob(int parameterIndex, Reader reader) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setClob", parameterIndex, reader)) {
      preparedStatement.setClob(parameterIndex, reader);
    }
  }
  @Override
  public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setBlob", parameterIndex, inputStream)) {
      preparedStatement.setBlob(parameterIndex, inputStream);
    }
  }
  @Override
  public void setNClob(int parameterIndex, Reader reader) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setNClob", parameterIndex, reader)) {
      preparedStatement.setNClob(parameterIndex, reader);
    }
  }
  @Override
  public void setObject(int parameterIndex, Object x, SQLType targetSqlType, int scaleOrLength) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setObject", parameterIndex, x, targetSqlType,
        scaleOrLength)) {
      preparedStatement.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
    }
  }
  @Override
  public void setObject(int parameterIndex, Object x, SQLType targetSqlType) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setObject", parameterIndex, x, targetSqlType)) {
      preparedStatement.setObject(parameterIndex, x, targetSqlType);
    }
  }
  @Override
  public int getMaxFieldSize() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getMaxFieldSize")) {
      return preparedStatement.getMaxFieldSize();
    }
  }
  @Override
  public void setMaxFieldSize(int max) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setMaxFieldSize", max)) {
      preparedStatement.setMaxFieldSize(max);
    }
  }
  @Override
  public int getMaxRows() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getMaxRows")) {
      return preparedStatement.getMaxRows();
    }
  }
  @Override
  public void setMaxRows(int max) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setMaxRows", max)) {
      preparedStatement.setMaxRows(max);
    }
  }
  @Override
  public void setEscapeProcessing(boolean enable) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setEscapeProcessing", enable)) {
      preparedStatement.setEscapeProcessing(enable);
    }
  }
  @Override
  public int getQueryTimeout() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getQueryTimeout")) {
      return preparedStatement.getQueryTimeout();
    }
  }
  @Override
  public void setQueryTimeout(int seconds) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setQueryTimeout", seconds)) {
      preparedStatement.setQueryTimeout(seconds);
    }
  }
  @Override
  public void cancel() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "cancel")) {
      preparedStatement.cancel();
    }
  }
  @Override
  public SQLWarning getWarnings() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getWarnings")) {
      return preparedStatement.getWarnings();
    }
  }
  @Override
  public void clearWarnings() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "clearWarnings")) {
      preparedStatement.clearWarnings();
    }
  }
  @Override
  public void setCursorName(String name) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setCursorName", name)) {
      preparedStatement.setCursorName(name);
    }
  }
  @Override
  public ResultSet getResultSet() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getResultSet")) {
      return preparedStatement.getResultSet();
    }
  }
  @Override
  public int getUpdateCount() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getUpdateCount")) {
      return preparedStatement.getUpdateCount();
    }
  }
  @Override
  public boolean getMoreResults() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getMoreResults")) {
      return preparedStatement.getMoreResults();
    }
  }
  @Override
  public void setFetchDirection(int direction) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setFetchDirection", direction)) {
      preparedStatement.setFetchDirection(direction);
    }
  }
  @Override
  public int getFetchDirection() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getFetchDirection")) {
      return preparedStatement.getFetchDirection();
    }
  }
  @Override
  public void setFetchSize(int rows) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setFetchSize", rows)) {
      preparedStatement.setFetchSize(rows);
    }
  }
  @Override
  public int getFetchSize() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getFetchSize")) {
      return preparedStatement.getFetchSize();
    }
  }
  @Override
  public int getResultSetConcurrency() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getResultSetConcurrency")) {
      return preparedStatement.getResultSetConcurrency();
    }
  }
  @Override
  public int getResultSetType() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getResultSetType")) {
      return preparedStatement.getResultSetType();
    }
  }
  @Override
  public void addBatch(String sql) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "addBatch", sql)) {
      preparedStatement.addBatch(sql);
    }
  }
  @Override
  public void clearBatch() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "clearBatch")) {
      preparedStatement.clearBatch();
    }
  }
  @Override
  public Connection getConnection() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getConnection")) {
      return preparedStatement.getConnection();
    }
  }
  @Override
  public boolean getMoreResults(int current) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getMoreResults", current)) {
      return preparedStatement.getMoreResults(current);
    }
  }
  @Override
  public ResultSet getGeneratedKeys() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getGeneratedKeys")) {
      return preparedStatement.getGeneratedKeys();
    }
  }
  @Override
  public int getResultSetHoldability() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getResultSetHoldability")) {
      return preparedStatement.getResultSetHoldability();
    }
  }
  @Override
  public boolean isClosed() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "isClosed")) {
      return preparedStatement.isClosed();
    }
  }
  @Override
  public void setPoolable(boolean poolable) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setPoolable", poolable)) {
      preparedStatement.setPoolable(poolable);
    }
  }
  @Override
  public boolean isPoolable() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "isPoolable")) {
      return preparedStatement.isPoolable();
    }
  }
  @Override
  public void closeOnCompletion() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "closeOnCompletion")) {
      preparedStatement.closeOnCompletion();
    }
  }
  @Override
  public boolean isCloseOnCompletion() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "isCloseOnCompletion")) {
      return preparedStatement.isCloseOnCompletion();
    }
  }
  @Override
  public long getLargeUpdateCount() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getLargeUpdateCount")) {
      return preparedStatement.getLargeUpdateCount();
    }
  }
  @Override
  public void setLargeMaxRows(long max) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "setLargeMaxRows", max)) {
      preparedStatement.setLargeMaxRows(max);
    }
  }
  @Override
  public long getLargeMaxRows() throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "getLargeMaxRows")) {
      return preparedStatement.getLargeMaxRows();
    }
  }
  @Override
  public String enquoteLiteral(String val) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "enquoteLiteral", val)) {
      return preparedStatement.enquoteLiteral(val);
    }
  }
  @Override
  public String enquoteIdentifier(String identifier, boolean alwaysQuote) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "enquoteIdentifier", identifier, alwaysQuote)) {
      return preparedStatement.enquoteIdentifier(identifier, alwaysQuote);
    }
  }
  @Override
  public boolean isSimpleIdentifier(String identifier) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "isSimpleIdentifier", identifier)) {
      return preparedStatement.isSimpleIdentifier(identifier);
    }
  }
  @Override
  public String enquoteNCharLiteral(String val) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "enquoteNCharLiteral", val)) {
      return preparedStatement.enquoteNCharLiteral(val);
    }
  }
  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "unwrap", iface)) {
      return preparedStatement.unwrap(iface);
    }
  }
  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    try (var measurer = handler.start("java.sql.PreparedStatement", "isWrapperFor", iface)) {
      return preparedStatement.isWrapperFor(iface);
    }
  }
}