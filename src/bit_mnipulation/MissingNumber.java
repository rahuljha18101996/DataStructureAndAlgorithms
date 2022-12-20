package bit_mnipulation;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int missing = 0;
        for (int i = 1; i <= nums.length; i++) missing ^= i;
        for (int n : nums) {
            missing ^= n;
        }
        return missing;
    }
}
