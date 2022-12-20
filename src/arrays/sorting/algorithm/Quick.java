package arrays.sorting.algorithm;

/*
* Quick Sort
* Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as a pivot and partitions the given array around the picked pivot. There are many versions of quickSort that pick pivot in different ways.
 * */
public class Quick {
    public void sort(int[] arr) {
        split(arr,0,arr.length - 1);
    }

    private void split(int[] arr,int left,int right) {
        if (left >= right) return;
        int pivot = fixPivot(arr,left,right);
        split(arr,left,pivot - 1);
        split(arr,pivot + 1,right);
    }

    private int fixPivot(int[] arr, int left, int right) {
        int j = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < arr[right]) {
                swap(arr,i,j);
                j++;
            }
        }
        swap(arr,j,right);
        return j;
    }

    private void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
