package design_pattern.solid;

import java.util.List;

/*
* Single Responsibility Principle
* Each class should have only one sole purpose and not filled with excessive functionality.
*
* For instance below class is used to print some kind of object which can iterate
* */
public class SingleResponsibilityPrinciple {
    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("]");
    }

    public static void printList(List<Integer> arr) {
        System.out.print("[ ");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("]");
    }
}
