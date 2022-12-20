package bit_mnipulation;

import java.util.ArrayList;
import java.util.List;

class BinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        int[] bits = countBits(59);
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if ((bits[i] + bits[j]) == turnedOn) {
                    list.add(String.format("%d:%02d",i,j));
                }
            }
        }
        return list;
    }
    public int[] countBits(int n) {
        int[] counter = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int x = i;
            while (x != 0) {
                counter[i]++;
                x = x & (x - 1);
            }
        }
        return counter;
    }
}
