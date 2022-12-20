Serialization:
Serialization is the process of saving object state to disc. Java object converted into byte stream.
1. Implement marker interface java.io.Serializable
2. ObjectOutputStream and ObjectInputStream
    Implement ObjectOutput & ObjectInput
3. Primitive & Arrays are by default serializable
4. Can save entire object graph
    - Fails if even one object is not serializable
    - Object with multiple references is saved only once
5. Static variables are not serialized
6. Superclass is serializable subclass is also serializable
7. Mark the instance variable as transient if you don't want to serialize it.
    Serialization: Variable value is skipped
    Deserialization: Variable get default value

Deserialization:
Deserialization is the process of reconstructing the serialized object into real object. 
1. Read Serialized Object
2. Find Serialized object's class name and load class object
3. Deserialization fails if,
    - class object cannot be loaded
    - version mismatch
4. Create new object on heap & restore its state, ie., objects constructor is not run
   - if there is non-serializable ancestor then
        >    run ancestor's constructor & 
        >    any constructor above that (even if they are serializable) 
   - Instance variable get serialized state
   - Transient variable get default value

SerialVersionUID
1. Every serializable class version ID computed from class structure
2.  Serialized object ~ stampled with SerialVersionUID
3.  Deserialization:
    serializedObj.serialVersionUID  == class.serialVersionUID

How can class evolve without hurting deserialization?
Add static final long serialVersionUID = -1776140628792096900L;

Change that do not affect deserialization:
- add/delete instance variable
- make instance variable static
- change instance variable from transient to non-transient'
- change access level of variables
- add/remove classes to/from inheritance tree


Use:
1. Important Web pages with frequent reads than writes
    - Serialize to disk or perform caching (eg. memcached)
2. Passing Java objects to remote hosts
3. Post-mortem analysis
