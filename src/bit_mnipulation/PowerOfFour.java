package bit_mnipulation;

public class PowerOfFour {
    public static boolean isPowerOfFour(int n) {
        int c = n;
        int p = 1;
        while (c > 1) {
            c = (c >> 1) >> 1;
            p = (p << 1) << 1;
        }
        return n == p;
    }
}
