package design_pattern.singleton;

/*
*
* Here using synchronized makes sure that only one thread at a time can execute getInstance().
The main disadvantage of this is method is that using synchronized every time while creating the singleton object is expensive and may decrease the performance of your program. However if performance of getInstance() is not critical for your application this method provides a clean and simple solution.
*
* */
public class SingletonExample2 {
    private static SingletonExample2 instance;
    public synchronized static SingletonExample2 getInstance() {
        if (instance == null) {
            instance = new SingletonExample2();
        }
        return instance;
    }
    private SingletonExample2() {}

    public void myCalculation() {
        System.out.println("I am doing some calculation");
    }
}
