package arrays.sorting.algorithm;

/*
* Insertion Sort
* The sorting algorithm work by keeping the subarray sorted.
* */
public class Insertion {
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i];
            int index = i - 1;
            while (index >= 0 && arr[index] > currentValue) {
                arr[index + 1] = arr[index--];
            }
            arr[index + 1] = currentValue;
        }
    }
}
