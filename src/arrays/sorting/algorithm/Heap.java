package arrays.sorting.algorithm;

/*
* Heap Sort
* Heap is a Binary Tree with the following property:
* Tree should be complete. Left node should be filled first before filing the right element.
* Every Node's key is larger than (or equal to) the key of its children.
*
* Heap Sort Algorithm
* Create a heap from the array elements.
* Poll (Fetch the Root and then delete the root) the element from the heap and store the element in the last.
* Repeat the process unti the heap become empty
* */
public class Heap {
    public void sort(int[] arr) {
        createHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--){
            swap(arr,0,i);
            fixHeapForward(arr,i);
        }
    }
    public void createHeap(int[] arr) {
        for (int i =0; i < arr.length; i++) {
            fixHeapReverse(arr,i);
        }
    }

    private void fixHeapForward(int[] arr, int limit) {
        int j = 0;
        while (j < limit) {
            int left = 2 * j + 1;
            int right = 2 * j + 2;
            if (left < limit && right < limit) {
                if (arr[left] >= arr[j] && arr[left] > arr[right]) {
                    swap(arr,left,j);
                    j = left;
                } else if (arr[right] >= arr[j] && arr[left] < arr[right]) {
                    swap(arr,right,j);
                    j = right;
                }else {
                    break;
                }
            } else if (left < limit) {
                if (arr[left] >= arr[j]) {
                    swap(arr,left,j);
                    j = left;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    private void fixHeapReverse(int[] arr, int i) {
        if (i == 0) return;
        int j = (i - 1) / 2;
        while (arr[i] > arr[j]) {
            swap(arr,i,j);
            i = j;
            j = (i - 1) / 2;
        }
    }
    private void swap(int[] arr, int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
