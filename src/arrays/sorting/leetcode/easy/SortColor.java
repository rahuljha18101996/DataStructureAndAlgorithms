package arrays.sorting.leetcode.easy;

public class SortColor {
    public void sortColors(int[] nums) {
        sort(nums,0,2);
    }
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
