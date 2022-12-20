package arrays.sorting.algorithm;

/*
* Counting Sort
* Note that it will only work with limited set of number 'k' such that 'k' is too much less than size of the number 'n'.
* Creating a list of 'k' elements store the count in the list and finally insert each number based on their count
* */

public class Counting {
    public void sort(int[] arr, int min, int max) {
        int[] counter = new int[max - min + 1];
        for (int element : arr) {
            counter[element - min]++;
        }
        int index = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 0) continue;
            int count = counter[i];
            while (count > 0) {
                arr[index++] = i + min;
                count--;
            }
        }
    }
}
