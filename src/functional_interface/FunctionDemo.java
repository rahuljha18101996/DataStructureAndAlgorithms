package functional_interface;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/*
 *
 * Function and BiFunction are function which accept one and two parameter respectively and return other data
 * Unary and Binary Operator are also same as Function and BiFunction just their parameter/s and return type are of same type
 * To use function we use apply function.
 *
 * */
public class FunctionDemo {
    public static Function<Integer,Integer> reverse = n -> {
        if (n < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }
        if (n < 10) return n;
        int rev = 0;
        for (int i = n; i > 0; i /= 10) {
            rev = (rev * 10) + (i % 10);
        }
        return rev;
    };

    public static BiFunction<Integer,Integer,Double> power = (x, y) -> {
        int z = 1;
        for (int i = 1; i <= Math.abs(y); i++) z *= x;
        if (y < 0) return  1.0 / (double) z;
        return (double)z;
    };

    public static UnaryOperator<Integer> square = n -> n * n;
    public static BinaryOperator<String> concat = (x, y) -> String.format("%s %s",x,y);

    public static void main(String[] args) {
        System.out.println(square.apply(5));
        System.out.println(concat.apply("Rahul", "Jha"));
    }
}
