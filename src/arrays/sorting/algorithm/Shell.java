package arrays.sorting.algorithm;

/*
* Shell Sort
* Shell Sort sorts the element based on the Knuth Sequence, h = 3i + 1
*
* Shell sort is mainly a variation of Insertion Sort. In insertion sort, we move elements only one position ahead. When an element has to be moved far ahead, many movements are involved. The idea of ShellSort is to allow the exchange of far items. In Shell sort, we make the array h-sorted for a large value of h. We keep reducing the value of h until it becomes 1. An array is said to be h-sorted if all sublists of every h’th element are sorted.
* */
public class Shell {
    public void sort(int[] arr) {
        int knuth_sequence = 1;//3h +1
        for ( ; 3 * knuth_sequence + 1 < arr.length; knuth_sequence = knuth_sequence * 3 + 1);
        for ( ; knuth_sequence >= 1; knuth_sequence = (knuth_sequence - 1) / 3) {
            for (int i = knuth_sequence; i < arr.length; i++) {
                int currentElement = arr[i];
                int index = i - knuth_sequence;
                while (index >= 0 && arr[index] > currentElement) {
                    arr[index + knuth_sequence] = arr[index];
                    index -= knuth_sequence;
                }
                arr[index + knuth_sequence] = currentElement;
            }
        }
    }
}
