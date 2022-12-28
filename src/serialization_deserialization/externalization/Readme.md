<b>Externalization in Java</b>

Externalization in Java is used to customize the serialization mechanism. Java serialization is not much efficient. When we have bloated objects that hold several attributes and properties, it is not good to serialize them. Here, the externalization will be more efficient.

Java serialization is not much effective when we have bloated objects with multiple attributes and properties. Here, externalization comes into role. It allows us to customize the serialization. For example, if we have implemented the Serialization interface in a class, we can externalize it using the writeExternal() method. When users reconstruct an externalized object from their end, an instance of the object will be created using the readExternal() method.

Thus, the externalization provides custom serialization, where we can manage our object stream and decide what to store in it.

The externalization is useful if we want to serialize a part of an object. We can serialize only the required fields of an object.

We are required to implement the java.io.Externalizable interface to control reading and writing during the serialization and deserialization. The methods readExternal() and writeExternal() are the parts of Externalizable interface.



<b>readExternal() method in Externalizable Interface</b>



The Externalizable interfaces' objects are implemented using the readExternal() method. It restores objects by calling the methods of DataInput for primitive types. It can call readObject for objects, strings, and arrays data type.

Let's understand how to implement the readExternal() method.

When we pass an object in the readExternal() method, it takes object input.

For primitive data types, we can use readBoolean(), readByte(), readInt(), readLong() methods.

For String, Arrays, or any of the custom classes, we can use the readObject() method.

public void readExternal(ObjectInput in) throws ClassNotFoundException, IOException {  
    this.code = in.readInt();  
    this.name = (String) in.readObject();  
    this.password = (String) in.readObject();  
    this.birthday = (Date) in.readObject();  
}  

From the above code snippet, the readInt() and readObject() methods are used to deserialize the values of code, name, password, and birthday.



<b>writeExternal() method in Externalizable Interface</b>


The writeExternal() method of the Externalizable interface is used to save the contents by calling the methods of dataOutput for primitive values. For the objects, strings, and arrays, call the writeObject method of ObjectOutput.

Let's understand the implementation of the writeExternal() method:

The following rules should be followed to write the object's state to the underlying stream:

For the primitive type values, the writeBoolean(), writeByte(), writeInt(), writeLong() methods are used.

For strings, arrays, and custom classes, the writeObject() method is used.

public void writeExternal(ObjectOutput out) throws IOException {  
    out.writeInt(code);  
    out.writeObject(name);  
    // write empty password:  
    out.writeObject("");  
    out.writeObject(birthday);  
}

<b>Difference between Serialization and Externalization</b>

<table>
<thead>
<tr>
<th>Key</th>
<th>Serialization</th>
<th>Externalization</th>
</tr>
</thead>

<tbody>
<tr>
<td>Iterface</td>
<td>It is a marker interface</td>
<td>Whereas, it contains two methods readExternal() and writeExternal()</td>
</tr>

<tr>
<td>Process</td>
<td>Default Serialization</td>
<td>Custom Serialization</td>
</tr>

<tr>
<td>UID</td>
<td>serialVersionUID</td>
<td>No UID</td>
</tr>

<tr>
<td>Storage</td>
<td>Stores the data that have objects</td>
<td>Directly stores objects</td>
</tr>

<tr>
<td>Access</td>
<td>No Access</td>
<td>Complete control to customize the serialization</td>
</tr>

<tr>
<td>Performance</td>
<td>It provides relatively slow performance.</td>
<td>It provides full control over the implementation approach.</td>
</tr>
</tbody>
</table>