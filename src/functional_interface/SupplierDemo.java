package functional_interface;

import java.util.function.Supplier;

/*
 *
 * Supplier are the function which are used to return a value of specific type.
 * To use supplier function we use get function.
 *
 * */
public class SupplierDemo {
    public static Supplier<String> someConnection = () -> "some connection";
}