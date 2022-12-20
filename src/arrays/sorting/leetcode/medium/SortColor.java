package arrays.sorting.leetcode.medium;
import arrays.sorting.algorithm.Counting;

/*
* Link: https://leetcode.com/problems/sort-colors/
* */
public class SortColor {
    public void sortColors(int[] nums) {
        new Counting().sort(nums,0,2);
    }
}
