<b>JVM Vs. JRE Vs. JDK</b>

Java Virtual Machine (JVM) is an abstract machine that executes
Java Bytecode. There are different JVM for different hardware and
software platforms. So JVM is platform dependent. JVM is
responsible for loading, verifying and executing the Bytecode on a
platform.

JRE stands for Java Runtime Environment. This is included in JDK.
JRE provides libraries and JVM that is required to run a Java
program.

JDK stands for Java Development Kit. It contains the tools and
libraries for development of Java programs. It also contains
compilers and debuggers needed to compile Java program.

<b>Memory Areas Allocated By JVM</b>

1. ClassLoader: It is a component of JVM used to load class
files.
2. Class (Method) Area: It stores per-class structures such as
   the runtime constant pool, field and method data, and the
   code for methods.
3. Heap: Heap is created a runtime, and it contains the runtime
   data area in which objects are allocated.
4. Stack: Stack stores local variables and partial results at
   runtime. It also helps in method invocation and return
   value. Each thread creates a private JVM stack at the time
   of thread creation.
5. Program Counter Register: This memory area contains the
   address of the Java virtual machine instruction that is
   currently being executed.
6. Native Method Stack: This area is reserved for all the
   native methods used in the application.

<b>JIT Compiler</b>

Just In Time compiler also known as JIT compiler is used for
performance improvement in Java. It is enabled by default. It is
compilation done at execution time rather earlier.
Java has popularized the use of JIT compiler by including it in
JVM. JIT compiler convert Hotspot into near machine code which run similar to machine code which improve performance.

<b>ClassLoader</b>

In Java, ClassLoader is a class that is used to load files in JVM.
ClassLoader loads files from their physical file locations e.g.
Filesystem, Network location etc.
There are three main types of ClassLoaders in Java.
1. Bootstrap ClassLoader: This is the first ClassLoader. It
   loads classes from rt.jar file.
2. Extension ClassLoader: It loads class files from jre/lib/ext
   location.
3. Application ClassLoader: This ClassLoader depends on
   CLASSPATH to find the location of class files. If you
   specify your jars in CLASSPATH, then this ClassLoader
   will load them.

<b>"main" is a Keyword?</b>

No, main is just a name of method. There can be multiple methods
with same name main in a class file. It is not a keyword in Java.

Can we write main method as public void static instead of public
static void?
No, you cannot write it like this. Any method has to first specify the
modifiers and then the return value. The order of modifiers can
change.
We can write static public void main() instead of public static void
main().

