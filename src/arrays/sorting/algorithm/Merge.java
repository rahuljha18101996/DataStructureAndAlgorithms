package arrays.sorting.algorithm;

import java.util.Arrays;

/*
* Merge Sort
* The Merge Sort algorithm is a sorting algorithm that is based on the Divide and Conquer paradigm. In this algorithm, the array is initially divided into two equal halves, and then they are combined in a sorted manner.
* */
public class Merge {
    public void sort(int[] arr) {
        divide(arr,0,arr.length - 1);
    }
    private void divide(int[] arr,int left,int right) {
        if (left >= right) return;
        int middle = (right - left) / 2 + left;
        divide(arr,left,middle);
        divide(arr,middle + 1,right);
        conquer(arr,left,middle,right);
    }

    private void conquer(int[] arr, int left, int middle, int right) {
        int[] copy = new int[right - left + 1];
        int m = middle;
        int n = right;
        for (int i = copy.length - 1; i >= 0; i--) {
            if (m >= left && n > middle) {
                if (arr[m] > arr[n]) {
                    copy[i] = arr[m--];
                }else {
                    copy[i] = arr[n--];
                }
            }else {
                if (m >= left) {
                    copy[i] = arr[m--];
                }else {
                    copy[i] = arr[n--];
                }
            }
        }

        n = 0;
        for (int i = left; i <= right; i++) {
            arr[i] = copy[n++];
        }
    }
}
