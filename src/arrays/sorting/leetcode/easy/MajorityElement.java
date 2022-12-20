package arrays.sorting.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int solution1(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int count = 1;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                count++;
            }else {
                if (count > max && count > (nums.length / 2)) {
                    result = nums[i - 1];
                    max = count;
                }
                count = 1;
            }
        }
        if (count > max && count > (nums.length / 2)) {
            result = nums[nums.length - 1];
        }
        return result;
    }

    public int solution2(int[] nums) {
        //Since the majority element are greater than half of the length, so majority element will be present at the middle
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int solution3(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i : nums) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        int result = 0;
        int max = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > max && map.get(key) >= (nums.length / 2)) {
                result = key;
                max = map.get(key);
            }
        }
        return result;
    }

    //Boyce Moore Algorithm
    public int solution4(int[] nums) {
        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
