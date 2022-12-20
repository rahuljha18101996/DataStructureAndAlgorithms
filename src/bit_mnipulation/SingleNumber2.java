package bit_mnipulation;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {
    public int singleNumber1(int[] a) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }

        return -1;
    }
    public int singleNumber2(int[] nums) {
        int a = 0, b = 0;
        for (int i : nums) {
            int x = (a ^ i) & ~b;
            int y = i & a | ~i & b;
            a = x;
            b = y;
        }
        return a;
    }
}
