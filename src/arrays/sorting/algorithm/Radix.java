package arrays.sorting.algorithm;
/*
* Radix Sort
* Radix Sort is to do digit by digit sort starting from the least significant digit to most significant digit. Radix sort uses counting sort as a subroutine to sort.
* */
public class Radix {
    public void sort(int[] arr) {
        int max = getMax(arr);
        for (int exponent = 1; (max / exponent) > 0; exponent *= 10) {
            arr = sort(arr,exponent);
        }
    }
    private int[] sort(int[] arr, int exponent) {
        int[] count = new int[10];
        int[] result = new int[arr.length];
        for (int i : arr) {
            count[(i / exponent) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            result[count[(arr[i] / exponent) % 10] - 1] = arr[i];
            count[(arr[i] / exponent) % 10]--;
        }
        return result;
    }
    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            max = Math.max(i,max);
        }
        return max;
    }
}
