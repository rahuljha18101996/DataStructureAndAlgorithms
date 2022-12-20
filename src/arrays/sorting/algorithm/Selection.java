package arrays.sorting.algorithm;

/*
* Selection Sort
* The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from the unsorted part and putting it at the beginning.
 * */
public class Selection {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i + 1;
            for (int j = index + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (arr[i] > arr[index]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }
}
