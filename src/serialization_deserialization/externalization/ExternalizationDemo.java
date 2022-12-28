package serialization_deserialization.externalization;


import java.io.*;

class User implements Externalizable {
    private String name;
    private int age;
    public User() {}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
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
    public String toString() {
        return String.format(
                "%s is %d years old",
                name,
                age
        );
    }
}
public class ExternalizationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("externalization.ser");
//        User user = new User("Piyush Bhawsar",25);
//        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        //ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

//        out.writeObject(user);

//        User user2 = (User)in.readObject();
//        System.out.println(user2);

        //--------------------

//        User[] users = {
//                new User("Piyush",25),
//                new User("Shikhar",26),
//                new User("Vikram",32)
//        };
//
//        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
//        out.writeObject(users);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        User[] usersList = (User[])in.readObject();
        for (User user : usersList) {
            System.out.println(user);
        }
    }
}
