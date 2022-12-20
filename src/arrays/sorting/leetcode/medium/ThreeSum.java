package arrays.sorting.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Url  : https://leetcode.com/problems/3sum/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] a) {
        List<List<Integer>> result = new ArrayList<>();
        if (a.length < 3) return result;
        //Sorting the list
        Arrays.sort(a);
        for (int i=0; i < a.length; i++) {
            //Max sum should be 0 and array is sorted so if a[i] is greater than 0 then we can break out from the loop
            if (a[i] > 0) break;
            //To ignore duplicate
            if (i > 0 && a[i] == a[i - 1]) continue;
            int first = a[i];
            int left = i + 1,right = a.length - 1;
            while (left < right) {
                int sum = first + a[left] + a[right];
                if (sum == 0) {
                    result.add(List.of(first,a[left],a[right]));
                    left++;
                    //To ignore duplicate
                    while (left < a.length && a[left] == a[left - 1]) {
                        left++;
                    }
                }else if (sum > 0) {
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;
    }
}
