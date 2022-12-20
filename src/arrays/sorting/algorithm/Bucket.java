package arrays.sorting.algorithm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
* Bucket Sort
* Creating the Bucket with the element and sorting the elements in each bucket and finally merging the elements in each bucket one by one to the array.
*
* How to decide which element will go in which bucket:
* In case of number the bucket will be decided based on Most Significant Digit.
* */

public class Bucket {
    public void sort(int[] arr) {
        final int BUCKET_SIZE = 10;
        List[] bucket = new List[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            bucket[i] = new LinkedList<>();
        }
        for (int element : arr) {
            bucket[(element / 100)].add(element);
        }
        for (var c : bucket) {
            Collections.sort(c);
        }

        int index = 0;
        for (List c : bucket) {
            for (Object i : c) {
                arr[index++] = (Integer) i;
            }
        }
    }
}
