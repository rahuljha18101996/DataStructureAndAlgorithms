package functional_interface;

@FunctionalInterface
interface  I {
    void m();
}

@FunctionalInterface
interface J<T> {
    void x(T t);
}

public class SAMDemo {
    public static void main(String[] args) {
        //Pre Java 8
        I i = new I() {
            @Override
            public void m() {
                System.out.println("Pre Java 8 Style...");
            }
        };

        i.m();

        //Java  8 Style
        I i8 = () -> {
            System.out.println("Java 8 Style...");
        };

        I _i8 = () -> System.out.println("Java 8 Style, Even More Simpler...");

        i8.m();
        _i8.m();

//        Cannot do this
//        var x = n -> {
//            System.out.println("Printing n : " + n);
//        };

        var x = new J<Integer>() {
            @Override
            public void x(Integer integer) {
                System.out.println("Printing value : " + integer);
            }
        };

        x.x(5);
    }
}

class OtherDemo {
    public int classVariable = 5;
    public void TestLambads() {
        int localVariable = 5;

        I i = () -> {
            classVariable++;
            //Below statement will throw an error
            //Variable used in lambda expression should be final or effectively final
            //Cannot change local variable in whole function
            System.out.println(localVariable);
            //localVariable++;
        };

        //Cannot even change here
        //localVariable++;

        //This is because functional interface instance can be called from anywhere within the function
    }
}

@FunctionalInterface
interface Recur {
    int fact(int n);
}

class RecursionUsingFunctionalInterfaces {
    public void showRecursion() {
        /*
         * If we want to implement recursion using the Lambdas, it needs to be implemented using old styles
         * */
        var x = new Recur() {
            @Override
            public int fact(int n) {
                if (n <= 1) return  1;
                return n * fact(n - 1);
            }
        };

        x.fact(10);
    }
}
