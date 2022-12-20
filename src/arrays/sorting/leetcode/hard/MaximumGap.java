package arrays.sorting.leetcode.hard;

import java.util.Arrays;

public class MaximumGap {
    public int solution1(int[] nums) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int max = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            max = Math.max(max,nums[i] - nums[i - 1]);
        }
        return max;
    }
    public int solution2(int[] nums) {
        if (nums.length < 2) return 0;
        int n = nums.length - 1;
        int min = Math.min(nums[0],nums[n]), max = Math.max(nums[0],nums[n]);
        for (int i = 1; i < n; i++) {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        if (min == max) return 0;
        int average = (max - min) / n;
        if ((max - min) % n != 0) average++;

        int[] minBucket = new int[n + 1];
        int[] maxBucket = new int[n + 1];
        Arrays.fill(minBucket,Integer.MAX_VALUE);
        Arrays.fill(maxBucket,Integer.MIN_VALUE);

        for (int i : nums) {
            int index = (i - min) / average;
            minBucket[index] = Math.min(minBucket[index],i);
            maxBucket[index] = Math.max(maxBucket[index],i);
        }
        int previous = Integer.MIN_VALUE, difference = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            if (minBucket[i] == Integer.MAX_VALUE) continue;
            if (maxBucket[i] == Integer.MIN_VALUE) previous = maxBucket[i];
            else {
                difference = Math.max(difference,minBucket[i] - previous);
                previous = maxBucket[i];
            }
        }
        return difference;
    }
}
