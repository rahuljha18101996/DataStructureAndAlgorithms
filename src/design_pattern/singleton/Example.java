package design_pattern.singleton;

public class Example {
    public static void main(String[] args) {
        SingletonExample se = SingletonExample.getInstance();
        se.myCalculation();
    }
}
