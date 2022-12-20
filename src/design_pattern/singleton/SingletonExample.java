package design_pattern.singleton;

/*
* Classic Instantiation
* */
public final class SingletonExample {
    private static SingletonExample instance;
    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }
    private SingletonExample() {}

    public void myCalculation() {
        System.out.println("I am doing some calculation");
    }
}
