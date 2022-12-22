/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

package dynamicproxies.ch3.solution32;

import dynamicproxies.util.*;
import dynamicproxies.util.measurement.*;
import org.junit.*;
import org.mockito.*;

import java.lang.reflect.*;
import java.sql.*;
import java.util.*;

import static org.junit.Assert.*;

public class DidThatWorkTest {
  private static final String SQL = "SELECT * FROM A";

  private Connection connection;
  private TimeMeasuringHandler handler;

  @Before
  public void setUp() throws Exception {
    connection = Mockito.mock(Connection.class);
    Statement statement = Mockito.mock(CallableStatement.class);
    Mockito.when(connection.createStatement())
        .thenReturn(statement);
    Mockito.when(statement.executeQuery(ArgumentMatchers.anyString()))
        .thenReturn(Mockito.mock(ResultSet.class));
    handler = Mockito.mock(TimeMeasuringHandler.class);
  }

  @Test
  public void testInvocationHandlerStructure() {
    assertTrue("should implement InvocationHandler",
        InvocationHandler.class
            .isAssignableFrom(TimeMeasuringInvocationHandler.class));
    assertTrue("should have a TimeMeasuringHandler field",
        Arrays.stream(TimeMeasuringInvocationHandler.class.getDeclaredFields())
            .anyMatch(declaredField -> TimeMeasuringHandler.class.equals(
                declaredField.getType())));
  }

  @Test
  public void testHandlerIsStarted() throws Throwable {
    createStatement(getInvocationHandler(Set.of(Statement.class)));
    Mockito.verify(handler).start("java.sql.Connection", "createStatement", null);
  }

  @Test
  public void testReturnValueIsProxied() throws Throwable {
    Object statement = createStatement(getInvocationHandler(
        Set.of(Statement.class)));
    assertTrue("result should be a proxy", statement instanceof Proxy);
    assertTrue("proxy should have a TimeMeasuringInvocationHandler",
        TimeMeasuringInvocationHandler.class.equals(
            InvocationHandlerExtractor.getInvocationHandler(statement)
                .getClass()));
  }

  @Test
  public void testReturnValueIsNotProxied() throws Throwable {
    Object statement = createStatement(getInvocationHandler(Set.of()));
    assertFalse("result should not be a proxy", statement instanceof Proxy);
  }

  @Test
  public void testRecursiveProxies() throws Throwable {
    Object statement = createStatement(getInvocationHandler(
        Set.of(Statement.class, ResultSet.class)));
    Object resultSet = Proxy.getInvocationHandler(statement).invoke(
        new Object(),  // this parameter isn't used
        Statement.class.getMethod("executeQuery",
            new Class<?>[] {String.class}),
        new Object[] {SQL}
    );
    assertTrue("result should be a proxy", resultSet instanceof Proxy);
  }

  @Test
  public void testOldHandCraftedProxiesAreDeleted() {
    isOldHandcraftedProxyDeleted("Connection");
    isOldHandcraftedProxyDeleted("Statement");
    isOldHandcraftedProxyDeleted("PreparedStatement");
  }

  private void isOldHandcraftedProxyDeleted(String name) {
    try {
      String className = getClass().getPackageName() + "." +
                             name + "Proxy";
      Class.forName(className);
      fail("Class " + className + " should be removed");
    } catch (ClassNotFoundException success) { }
  }

  private Object createStatement(
      TimeMeasuringInvocationHandler invocationHandler) throws Throwable {
    return invocationHandler.invoke(
        new Object(),  // this parameter isn't used
        Connection.class.getMethod("createStatement"),
        null
    );
  }

  private TimeMeasuringInvocationHandler getInvocationHandler(
      Set<Class<?>> returnTypesToRecursivelyProxy) {
    return new TimeMeasuringInvocationHandler(
        connection, handler, returnTypesToRecursivelyProxy);
  }
}