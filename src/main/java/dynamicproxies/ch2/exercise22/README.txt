Most, if not all, real-world applications spend more time in the database than
any other component. In this exercise, we will develop a system for measuring
how long everything takes.

We have written a special JDBC driver called TimeMeasuringDriver. We create
this with a TimeMeasuringHandler that will emit events for all database
operations taking longer than the specified threshold. For example, to log
anything taking longer than 20 milliseconds, we would initialize our driver
like so:

    TimeMeasuringDriver.init(
        ConnectionProxy::new,
        new TimeMeasuringHandler(
            new MeasurementComposite(printer, measurements),
            20, TimeUnit.MILLISECONDS
        )
    );

When this driver is registered, it deregisters all other JDBC drivers currently
installed, then registers itself first, and afterwards re-registers the other
drivers in the order they were before.

Our TimeMeasuringDriver is configured to accept *all* jdbc URLs. It then finds
a driver in the rest of the driver list that works with that URL and wraps it
with our ConnectionProxy. When we call createStatement() on the ConnectionProxy,
we again wrap that with our time measuring StatementProxy.

In the exercise we want to implement the code wrapping Connection, Statement
and PreparedStatement. We will assume that get an individual column from a
ResultSet is probably not our bottleneck, but rather, the actual queries
executed on our database. However, if you are feeling ambitious, feel free to
also proxy the ResultSet (or wait until the next chapter).

The actual code for measuring the time will use the Java 7 try-with-resource
construct, for example:

// inside ConnectionProxy:

  @Override
  public Statement createStatement(
      int resultSetType, int resultSetConcurrency,
      int resultSetHoldability) throws SQLException {
    try (var measurer = handler.start("java.sql.Connection",
        "createStatement", resultSetType, resultSetConcurrency,
        resultSetHoldability)) {
      return new StatementProxy(connection.createStatement(resultSetType,
          resultSetConcurrency, resultSetHoldability), handler);
    }
  }

When we call handler.start(), we pass in the name of the interface we are
measuring, plus the method name and the parameter values. The method start()
returns an object that holds the current time offset from System.nanoTime() and
has the magical property that it implements AutoCloseable. Once we exit the
try() {} block, close() is called on this object, which stops the clock. If we
have exceeded the threshold, we also print the results to whatever
TimeMeasuringHandler we specified when we initialized TimeMeasuringDriver.
The beauty of try-with-resource is that it handles checked exceptions and
return values transparently. This would not be the case if we were to try use
lambdas for wrapping our calls.

It is a bit tedious writing out the interface name, the method name and the
parameter list every time. In theory you could try writing a template in your
IDE to automate this for you. However, don't despair as we will use dynamic
proxies in the next chapter to get this job done with MUCH less effort.

Good luck and once you're done, try see which are the worst time wasters by
running SlowDatabaseQueriesDemo. The DidThatWorkTest unit test checks that you
have implemented all that is required for this exercise.