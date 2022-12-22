module eu.javaspecialists.courses.dynamicproxies {
  requires java.logging;
  requires java.sql;
  requires junit;
  requires org.mockito;

  requires eu.javaspecialists.books.dynamicproxies;
  requires java.management;

  opens dynamicproxies.ch6.solution61 to eu.javaspecialists.books.dynamicproxies;
  opens dynamicproxies.ch5.solution51 to eu.javaspecialists.books.dynamicproxies;
  opens dynamicproxies.ch5.solution52 to eu.javaspecialists.books.dynamicproxies;
  opens dynamicproxies.ch6.exercise61 to eu.javaspecialists.books.dynamicproxies;
  opens dynamicproxies.ch5.exercise51 to eu.javaspecialists.books.dynamicproxies;
  opens dynamicproxies.ch5.exercise52 to eu.javaspecialists.books.dynamicproxies;

  exports dynamicproxies.util.measurement;

  // For unit tests:
  exports dynamicproxies.ch2.exercise21 to junit;
  exports dynamicproxies.ch2.exercise22 to junit;
  exports dynamicproxies.ch2.solution21 to junit;
  exports dynamicproxies.ch2.solution22 to junit;
  exports dynamicproxies.ch3.exercise31 to junit, eu.javaspecialists.books.dynamicproxies;
  exports dynamicproxies.ch3.exercise32 to junit;
  exports dynamicproxies.ch3.solution31 to junit, eu.javaspecialists.books.dynamicproxies;
  exports dynamicproxies.ch3.solution32 to junit;
  exports dynamicproxies.ch4.exercise41 to junit;
  exports dynamicproxies.ch4.exercise42 to junit;
  exports dynamicproxies.ch4.solution41 to junit;
  exports dynamicproxies.ch4.solution42 to junit;
  exports dynamicproxies.ch5.exercise51 to junit;
  exports dynamicproxies.ch5.exercise52 to junit;
  exports dynamicproxies.ch5.exercise53 to junit, eu.javaspecialists.books.dynamicproxies;
  exports dynamicproxies.ch5.solution51 to junit;
  exports dynamicproxies.ch5.solution52 to junit;
  exports dynamicproxies.ch5.solution53 to junit, eu.javaspecialists.books.dynamicproxies;
  exports dynamicproxies.ch6.exercise61 to junit;
  exports dynamicproxies.ch6.exercise62 to junit;
  exports dynamicproxies.ch6.solution61 to junit;
  exports dynamicproxies.ch6.solution62 to junit;

  // please let us know if we need to export more by emailing
  // heinz@javaspecialists.eu
}