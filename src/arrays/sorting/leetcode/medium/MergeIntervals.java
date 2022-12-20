package arrays.sorting.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Url : https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        List<int[]> temp = new ArrayList<>();
        //Sort the array
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length; ) {
            int min = intervals[i][0];
            int max = intervals[i][1];
            int j;
            for (j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] >=min && intervals[j][0] <= max) {
                    max = Math.max(max,intervals[j][1]);
                }else {
                    break;
                }
            }
            temp.add(new int[]{min,max});
            i += j - i;
        }
        int[][] result = new int[temp.size()][2];
        int index=0;
        for (int[] i : temp) {
            result[index++] = i;
        }
        return result;
    }
}
