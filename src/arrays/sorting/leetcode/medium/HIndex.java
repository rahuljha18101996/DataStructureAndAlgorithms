package arrays.sorting.leetcode.medium;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] c) {
        Arrays.sort(c);
        int n = c.length -1;
        int mid = n / 2;
        int hIndex = 0;
        while (mid >= 0 && mid <= n) {
            int papers = n - mid + 1;
            if (papers <= c[mid]) {
                hIndex = Math.max(hIndex,papers);
                mid--;
                papers = n - mid + 1;
                while (mid >= 0 && papers <= c[mid]) {
                    hIndex = Math.max(hIndex,papers);
                    mid--;
                    papers = n - mid + 1;
                }
                break;
            }else {
                mid++;
            }
        }
        return hIndex;
    }
}
