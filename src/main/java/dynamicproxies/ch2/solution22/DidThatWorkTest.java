/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch2.solution22;

import dynamicproxies.util.measurement.*;
import org.junit.*;
import org.mockito.*;

import java.lang.reflect.*;
import java.sql.*;
import java.util.*;

import static org.junit.Assert.*;

public class DidThatWorkTest {
  private static final String SQL = "SELECT * FROM A";

  private TimeMeasuringHandler handler;
  private ConnectionProxy connectionProxy;
  private StatementProxy statementProxy;
  private PreparedStatementProxy preparedStatementProxy;

  @Before
  public void setUp() throws Exception {
    handler = Mockito.mock(TimeMeasuringHandler.class);
    connectionProxy = new ConnectionProxy(Mockito.mock(Connection.class),
        handler);
    statementProxy = new StatementProxy(Mockito.mock(Statement.class),
        handler);
    preparedStatementProxy =
        new PreparedStatementProxy(Mockito.mock(PreparedStatement.class),
            handler);
  }

  @Test
  public void testConnectionProxyStructure() {
    assertTrue("should implement Connection",
        Connection.class.isAssignableFrom(ConnectionProxy.class));
    assertTrue("should have a TimeMeasuringHandler field",
        TestHelper.hasTimeMeasuringHandlerField(ConnectionProxy.class.getDeclaredFields()));
  }

  @Test
  public void testStatementProxyStructure() {
    assertTrue("should implement Statement",
        Statement.class.isAssignableFrom(StatementProxy.class));
    assertTrue("should have a TimeMeasuringHandler field",
        TestHelper.hasTimeMeasuringHandlerField(StatementProxy.class.getDeclaredFields()));
  }

  @Test
  public void testPreparedStatementProxyStructure() {
    assertTrue("should implement PreparedStatement",
        PreparedStatement.class.isAssignableFrom(PreparedStatementProxy.class));
    assertTrue("should have a TimeMeasuringHandler field",
        TestHelper.hasTimeMeasuringHandlerField(PreparedStatementProxy.class.getDeclaredFields()));
  }

  @Test
  public void testConnectionMethodsReturningStatement()
      throws SQLException, ReflectiveOperationException {
    TestHelper.checkHandlerIsCalled(handler,
        StatementProxy.class, connectionProxy, "createStatement");
    TestHelper.checkHandlerIsCalled(handler,
        StatementProxy.class, connectionProxy, "createStatement",
        ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    TestHelper.checkHandlerIsCalled(handler,
        StatementProxy.class, connectionProxy, "createStatement",
        ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY,
        ResultSet.CLOSE_CURSORS_AT_COMMIT);
  }

  @Test
  public void testConnectionMethodsReturningPreparedStatement()
      throws SQLException, ReflectiveOperationException {
    TestHelper.checkHandlerIsCalled(handler,
        PreparedStatementProxy.class, connectionProxy, "prepareStatement",
        SQL);
    TestHelper.checkHandlerIsCalled(handler,
        PreparedStatementProxy.class, connectionProxy, "prepareStatement",
        SQL, TestHelper.COLUMN_INDEXES);
    TestHelper.checkHandlerIsCalled(handler,
        PreparedStatementProxy.class, connectionProxy, "prepareStatement",
        SQL, TestHelper.COLUMN_NAMES);

    TestHelper.checkHandlerIsCalled(handler,
        PreparedStatementProxy.class, connectionProxy, "prepareStatement",
        SQL, Statement.RETURN_GENERATED_KEYS);
    TestHelper.checkHandlerIsCalled(handler,
        PreparedStatementProxy.class, connectionProxy, "prepareStatement",
        SQL, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    TestHelper.checkHandlerIsCalled(handler,
        PreparedStatementProxy.class, connectionProxy, "prepareStatement",
        SQL, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY,
        ResultSet.CLOSE_CURSORS_AT_COMMIT);
  }

  @Test
  public void testConnectionCloseMethod()
      throws SQLException, ReflectiveOperationException {
    TestHelper.checkHandlerIsCalled(handler, connectionProxy, "close");
  }

  @Test
  public void testStatementExecuteMethods()
      throws SQLException, ReflectiveOperationException {
    TestHelper.checkHandlerIsCalled(handler,
        statementProxy, "execute", SQL);
    TestHelper.checkHandlerIsCalled(handler,
        statementProxy, "executeQuery", SQL);
    TestHelper.checkHandlerIsCalled(handler,
        statementProxy, "executeUpdate", SQL);
    TestHelper.checkHandlerIsCalled(handler,
        statementProxy, "executeLargeUpdate", SQL);

    TestHelper.checkHandlerIsCalled(handler,
        statementProxy, "execute", SQL, Statement.RETURN_GENERATED_KEYS);
    TestHelper.checkHandlerIsCalled(handler,
        statementProxy, "executeUpdate", SQL, Statement.RETURN_GENERATED_KEYS);
    TestHelper.checkHandlerIsCalled(handler,
        statementProxy, "executeLargeUpdate", SQL,
        Statement.RETURN_GENERATED_KEYS);

    TestHelper.checkHandlerIsCalled(handler,
        statementProxy, "execute", SQL, TestHelper.COLUMN_INDEXES);
    TestHelper.checkHandlerIsCalled(handler,
        statementProxy, "executeUpdate", SQL, TestHelper.COLUMN_INDEXES);
    TestHelper.checkHandlerIsCalled(handler,
        statementProxy, "executeLargeUpdate", SQL, TestHelper.COLUMN_INDEXES);

    TestHelper.checkHandlerIsCalled(handler,
        statementProxy, "execute", SQL, TestHelper.COLUMN_NAMES);
    TestHelper.checkHandlerIsCalled(handler,
        statementProxy, "executeUpdate", SQL, TestHelper.COLUMN_NAMES);
    TestHelper.checkHandlerIsCalled(handler,
        statementProxy, "executeLargeUpdate", SQL, TestHelper.COLUMN_NAMES);

    TestHelper.checkHandlerIsCalled(handler,
        statementProxy, "executeBatch");
    TestHelper.checkHandlerIsCalled(handler,
        statementProxy, "executeLargeBatch");
  }

  @Test
  public void testStatementCloseMethod()
      throws SQLException, ReflectiveOperationException {
    TestHelper.checkHandlerIsCalled(handler, statementProxy, "close");
  }

  @Test
  public void testPreparedStatementExecuteMethods()
      throws SQLException, ReflectiveOperationException {
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "execute");
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "executeQuery");
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "executeUpdate");
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "executeLargeUpdate");

    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "execute", SQL);
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "executeQuery", SQL);
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "executeUpdate", SQL);
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "executeLargeUpdate", SQL);

    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "execute", SQL, PreparedStatement.RETURN_GENERATED_KEYS);
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "executeUpdate", SQL, PreparedStatement.RETURN_GENERATED_KEYS);
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "executeLargeUpdate", SQL, PreparedStatement.RETURN_GENERATED_KEYS);

    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "execute", SQL, TestHelper.COLUMN_INDEXES);
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "executeUpdate", SQL, TestHelper.COLUMN_INDEXES);
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "executeLargeUpdate", SQL, TestHelper.COLUMN_INDEXES);

    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "execute", SQL, TestHelper.COLUMN_NAMES);
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "executeUpdate", SQL, TestHelper.COLUMN_NAMES);
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "executeLargeUpdate", SQL, TestHelper.COLUMN_NAMES);

    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "executeBatch");
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "executeLargeBatch");
  }

  @Test
  public void testPreparedStatementCloseMethod()
      throws SQLException, ReflectiveOperationException {
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy, "close");
  }

  @Test
  public void testPreparedStatementOtherMethods()
      throws SQLException, ReflectiveOperationException {
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "addBatch");
    TestHelper.checkHandlerIsCalled(handler, preparedStatementProxy,
        "setObject", 1, new Object());
  }

  static class TestHelper {
    public static int[] COLUMN_INDEXES = new int[] {1};
    public static String[] COLUMN_NAMES = new String[] {"name"};

    public static boolean hasTimeMeasuringHandlerField(Field[] declaredFields) {
      return Arrays.stream(declaredFields).anyMatch(
          declaredField ->
              TimeMeasuringHandler.class.equals(declaredField.getType()));
    }

    public static void checkHandlerIsCalled(
        TimeMeasuringHandler handler, Object proxy,
        String methodName, Object... args) throws ReflectiveOperationException {
      checkHandlerIsCalled(handler, null, proxy, methodName, args);
    }

    public static void checkHandlerIsCalled(
        TimeMeasuringHandler handler, Class<?> expectedReturnType, Object proxy,
        String methodName, Object... args) throws ReflectiveOperationException {
      Class<?> iface = proxy.getClass().getInterfaces()[0];
      Method method = iface.getMethod(methodName, getParameterTypes(args));
      Object result = method.invoke(proxy, args);

      Mockito.verify(handler).start(iface.getName(), methodName, args);

      if (expectedReturnType != null) {
        assertTrue(methodName + " must return a " + expectedReturnType.getName(),
            result.getClass().equals(expectedReturnType));
      }
    }

    // This is not a generalised method
    private static Class<?>[] getParameterTypes(Object[] args) {
      Class<?>[] parameterTypes = new Class<?>[args.length];
      for (int i = 0; i < args.length; i++) {
        Class<?> clazz = args[i].getClass();
        // Connection, Statement and PreparedStatement use int only
        if (clazz == Integer.class) {
          parameterTypes[i] = int.class;
        } else {
          parameterTypes[i] = clazz;
        }
      }
      return parameterTypes;
    }
  }
}