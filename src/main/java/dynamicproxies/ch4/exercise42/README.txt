Queue is derived from Collection. It thus inherits methods such as size() that
do not necessarily make sense for a Queue. For example, since
ConcurrentLinkedQueue wants to avoid a "hot field", every time we call size(),
it has to count how many elements are in the structure. If a lot of threads are
adding and removing elements to a ConcurrentLinkedQueue, size() might never
return.

Other methods that might potentially take a long time to return are the
standard methods from Object: hashCode(), equals() and toString(). Each of these
involves iterating over the elements of the queue, with unpredictable results.
If we add/remove faster than we can iterate, these methods might only return
once we get an OutOfMemoryError.

In our Ουρά interface we want to only include those methods that should return
in a reasonable amount of time, even under heavy load:

    boolean offer(E e);
    E remove();
    E poll();
    E element();
    E peek();
    boolean isEmpty();

For the standard Object methods hashCode(), equals() and toString() we want to
use the default behaviour for Object.  That means, hashCode() should return
the System.identityHashCode(), equals() should compare the objects with ==,
and toString() should return getClass() + "@" + Integer.toHexString(hashCode()).
We can implement these methods inside StandardObjectMethodsInvocationHandler.
Hint: MethodKey can be useful to match the methods quickly.

The FilterHandlerWihStandardObjectMethods is like the FilterHandler from the
book, but where the first link in the chain is the our handler for standard
Object methods.