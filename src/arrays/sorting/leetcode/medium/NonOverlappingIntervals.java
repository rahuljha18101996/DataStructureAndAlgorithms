package arrays.sorting.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) return 1;
        int result = 0;
        //Sort the array
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int left =0;
        int right = 1;

        while(right<intervals.length){
            if(intervals[left][1] <= intervals[right][0]){
                left = right;
                right+=1;
            }else if(intervals[left][1] <= intervals[right][1]){
                result+=1;
                right+=1;
            }else if(intervals[left][1] > intervals[right][1]){
                result+=1;
                left = right;
                right+=1;
            }
        }
        return result;
    }
}
