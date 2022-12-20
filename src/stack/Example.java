package stack;

import java.util.Iterator;

public class Example {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        System.out.println(stack.push(1));
        System.out.println(stack.push(2));
        System.out.println(stack.push(3));
        System.out.println(stack.pop());
        System.out.println(stack.push(4));
        System.out.println(stack.push(5));
        System.out.println(stack.pop());
        System.out.println(stack.push(6));
        System.out.println(stack.push(7));
        System.out.println(stack.push(8));

        System.out.println();
        System.out.println();
        System.out.println();

        for (Integer integer : stack) {
            System.out.println(integer);
        }

    }
}
