package serialization_deserialization;

import java.io.*;
import java.util.Objects;

class Person implements Serializable {
    static final long serialVersionUID = -1776140628792096900L;
    private int id;
    private String name;
    private transient int age;

    private String gender;
    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Demo {
    public static void main(String[] args) {
//        Person p = new Person(101,"Pappu",10);
//        new SerializationDemo().Serialize(p);

        Person p1 = new DeserializationDemo().Deserialize();
        System.out.println(p1);
    }
}

class SerializationDemo {
    public void Serialize(Person p) {
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("object.ser")))) {
            out.writeObject(p);
            System.out.println("Done Serialization");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class DeserializationDemo {
    public Person Deserialize() {
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("object.ser")));) {
           Person p = (Person) in.readObject();
            System.out.println("Done Deserialization");
           return p;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
