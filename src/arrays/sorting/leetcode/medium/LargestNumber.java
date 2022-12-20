package arrays.sorting.leetcode.medium;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        int[][] a = new int[nums.length][2];
        int allZero = 0;
        for (int i = 0; i < nums.length; i++) {
            a[i][0] = nums[i];
            a[i][1] = countDigits(nums[i]);
            if (nums[i] == 0) allZero++;
        }

        if (allZero == nums.length) return "0";

        Arrays.sort(a, (x, y) -> {
            if (x[0] == 0 || y[0] == 0) return -Integer.compare(x[0],y[0]);
            long m = (long)y[0] * (int) Math.pow(10,x[1]) + (long)x[0];
            long n = (long)x[0] * (int) Math.pow(10,y[1]) + (long)y[0];
            return Long.compare(m,n);
        });

        StringBuilder sbr = new StringBuilder();
        for (int[] i : a) {
            sbr.append(i[0]);
        }
        return sbr.toString();
    }

    public int countDigits(int n) {
        int d = 0;
        for (;n > 0; n /= 10) {
            d++;
        }
        return d;
    }
}
