In exercise 2.2, we spent hours painstakingly wrapping the methods of the
interfaces Connection, Statement and PreparedStatement. There are two issues
with this approach. Firstly, it's a lot of work, and who has time for all that?
OK, if we're being paid to work on an hourly basis, we might have scored a cool
few hundred bucks there, but it's boring monkey work and not very inspiring.
Secondly, if we move to a newer version of JDBC with new methods, we would need
to also add those to our proxies. Oh and there's a third reason: It's
incredibly easy to make mistakes in the name of the method or parameters.

But there is relief for our pains!

Instead of all that work, we should rather just create dynamic proxies,
supported by the TimeMeasuringInvocationHandler.