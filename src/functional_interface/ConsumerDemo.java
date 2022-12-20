package functional_interface;

/*
 *
 * Consumer and BiConsumer are the function which accept one or two parameter and return nothing
 * To use consumer function accept function is used.
 *
 * */

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static Consumer<String> nameFormatter = name -> {
        char lastCharacter = name.charAt(name.length() - 1);
        name += " ";
        if ("aeiou".contains(String.valueOf(lastCharacter))) {
            System.out.printf("Mrs. %s%n",name.substring(0,name.indexOf(' ')));
        }else {
            System.out.printf("Mr. %s%n",name.substring(0,name.indexOf(' ')));
        }
    };

    public static BiConsumer<String,String> fullName = (firstName, lastName) -> System.out.printf("%s %s%n",firstName,lastName);
}
