package bit_mnipulation;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        if (x == y) return 0;
        int i = x ^ y;
        int counter = 0;
        while (i != 0) {
            counter++;
            i = i & (i - 1);
        }
        return counter;
    }
}
