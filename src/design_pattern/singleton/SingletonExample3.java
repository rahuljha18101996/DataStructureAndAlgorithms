package design_pattern.singleton;

/*
* Eager Instantiation
* */
public class SingletonExample3 {
    private static SingletonExample3 instance = new SingletonExample3();
    public static SingletonExample3 getInstance() {
        return instance;
    }
    private SingletonExample3() {}

    public void myCalculation() {
        System.out.println("I am doing some calculation");
    }
}
