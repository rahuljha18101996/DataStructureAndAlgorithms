package bit_mnipulation;
/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
* */

public class SingleNumber {
    /*
    * Algorithm:
    * Use XOR : XOR of 2 numbers is 0
    * */
    public static int singleNumber(int[] nums) {
        int n = 0;
        for (int i : nums) n ^= i;
        return n;
    }
}
