package bit_mnipulation;
public class CountingBits {
    public static int[] countBits(int n) {
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
