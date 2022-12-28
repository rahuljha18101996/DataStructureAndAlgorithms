package design_pattern.proxy;

/*
* Proxy Design Pattern
*
* Structural Design Pattern : Improve the structure of code
* Used when you want to control access. i.e., In Databases, you would want to control the 'delete' query available for certain users like admin.
*
* In general, we have class which is executing interface executer method, which is executing all commands.
* To control this, we add a Proxy class which implement the same interface and write the condition for Admins user before proceeding to actual executer.
*
* */
interface DatabaseExecuter {
    void executeDatabase(String query) throws Exception;
}

class DatabaseExecuterImplementation implements DatabaseExecuter {

    @Override
    public void executeDatabase(String query) throws Exception {
        System.out.printf("Going to to execute Query: %s", query);
    }
}

class DatabaseExecuterProxy implements DatabaseExecuter {
    private boolean isAdmin;
    DatabaseExecuterImplementation dbExecuter;

    public DatabaseExecuterProxy(String name,String password) {
        if (name.equals("Admin") && password.equals("Admin123")) {
            isAdmin = true;
        }
        dbExecuter = new DatabaseExecuterImplementation();
    }

    @Override
    public void executeDatabase(String query) throws Exception {
        if (isAdmin) {
            dbExecuter.executeDatabase(query);
        }else {
            if (query.contains("DELETE")) {
                throw new Exception("DELETE not allowed for non admin user");
            }else {
                dbExecuter.executeDatabase(query);
            }
        }
    }
}
public class ProxyDemo {
    public static void main(String[] args) throws Exception {
//        DatabaseExecuter nonAdmin = new DatabaseExecuterProxy("NonAdmin","SomePass");
//        nonAdmin.executeDatabase("DELETE");

        DatabaseExecuter admin = new DatabaseExecuterProxy("Admin","Admin123");
        admin.executeDatabase("DELETE");
    }
}
