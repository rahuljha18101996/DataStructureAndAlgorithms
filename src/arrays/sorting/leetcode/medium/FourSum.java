package arrays.sorting.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Url : https://leetcode.com/problems/4sum/
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        //Sorting the list
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target) break;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int first = nums[i];
            for (int j = i + 1; nums.length - j >= 3; j++) {
                if (j > (i + 1) && nums[j -1] == nums[j]) continue;
                int second = nums[j];
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = first + second + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(
                                List.of(first,second,nums[left],nums[right])
                        );
                        left++;
                        while (left < nums.length && nums[left - 1] == nums[left]) {
                            left++;
                        }
                    }else if (sum > target) {
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
