package design_pattern.singleton;

/*
* Best Approach
* Double Checked Locking
* We have declared the obj volatile which ensures that multiple threads offer the obj variable correctly when it is being initialized to Singleton instance. This method drastically reduces the overhead of calling the synchronized method every time.
* */
public class SingletonExample4 {
    private static volatile SingletonExample4 instance = null;

    public static SingletonExample4 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }

    private SingletonExample4() {

    }

    public void myCalculation() {
        System.out.println("I am doing some calculation");
    }
}
