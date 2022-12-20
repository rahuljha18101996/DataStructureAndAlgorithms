Race Condition ~ Check-then-act
Mutual Exclusion ~ Only one thread at a time allow to enter into function at particular instant of time
Non-thread-safe object -> incorrect program -> data corruption
Thread safe -> An object does not have any instance variable only work on local variables

Synchronization:
1. Locking machinism to prevent from mutual exclusion
2. Protect critical(shared mutable) data
3. Has 2 parts
   Lock
   Block of code guided by the lock
4. Uses synchronized keyword
5.

public void go() {
//Non critical stuff
synchronized(this) {
//critical st1
//critical st2
}
//Non critical stuff
}
6. Synchronization is expensive

Locking
1.  Every object has single lock
2.  Automatically acquired by the thread entering synchronized block
3.  Automatically released when thread exits synchronized block or due to exception
4.  At most one thread can acquire an object's lock
5.  if lock is unavailable, then thread goes into BLOCKED state
6.  BuiltIn lock are called Intrinsic or Monitor lock
7.  lock unavailable can't access Any object's synchronized method
8.  no restriction on non-synchronized method
9.  static synchronized method uses class object for lock
10. Cannot apply for class/constructor
11. Synchronization = Mutual Exclusion + reliable thread communication


Java Memory Model - JMM

Happens-Before ordering
> Program Order
> Lock ~ got to be same lock
> Volatile variables
> start()
> join()
> interrupt()
> Object.finalize()
> transitivity

*****************************************************
No thread coordination ~ Needed for performance
Typically threads do their own stuff
thread coordination on every write is very expensive
thread coordination ~ needed for shared,mutable data
thread coordination ~ program responsibility not JVM
*****************************************************


Volatile
> Keyword for variables
> Alternative way to ensure memory visibility
> Stored in main memory ~ no register or cache
> Used with shared mutable variable


Atomic Variable
> comes from java.util.concurrent.atomic.AtomicX;
> Thread safe
> Internally uses volatile
> Ensure memory visibility
> Source Code
> optimistic Locking
public final long incrementAndGet() {
for (;;) {
long current = get();
long next = current + !;
if (compareAndSet(current,next)) {
return next;
}
}
> Atomic Variable Class
Scalars : AtomicLong,AtomicInteger(Subclasses of lang.number),AtomicBoolean,AtomicReference
Arrays  : AtomicLongArray,AtomicIntegerArray,AtomicReferenceArray
Field Updaters : AtomicLongFieldUpdater,AtomicIntegerFieldUpdater,AtomicReferenceFieldUpdater
Compound Variables : AtomicMarkableReference,AtomicStampedReference

> Synchronize what needed
Keep Synchronize block small
Try to move time consuming activities out of synchronized block without affecting the thread safety
Avoid excessive synchronization
Cost
Thread Suspension & resumption
Lock Acquisition and release
Ensuring consistent memory visibility
Limit JVM's ability to optimize code execution
StringBuffer uses synchronization.

Interruption
> Every thread has a boolean  interrupted status
interrupt() : set status to true which is initially false
Clear interrupted status
Throw InterruptedException
> Thread blocked due to :
Stream IO ~ Uninterruptible -> Work around close the stream
Synchronized locks ~ Uninterruptible -> Use Explicit lock instead
NIO -> interruptible


Explicit Lock
