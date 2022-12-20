package arrays.sorting.leetcode.medium;

import java.util.Arrays;

//Url : https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {
    public int threeSumClosest(int[] a, int target) {
        if (a.length < 3) return -1;
        //Sorting the Array
        Arrays.sort(a);
        int result = a[0] + a[1] + a[2];
        if (a.length == 3) return result;
        for (int i = 0; i < a.length; i++) {
            if (i > 0 && a[i - 1] == a[i]) continue;
            int first = a[i];
            int left = i +1, right = a.length - 1;
            while (left < right) {
                int sum = first + a[left] +a[right];
                if (sum == target) {
                    result = target;
                    break;
                }else if (sum > target) {
                    right--;
                }else {
                    left++;
                }
                //Checking for closest
                if (Math.abs(target - sum) < Math.abs(target- result)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
