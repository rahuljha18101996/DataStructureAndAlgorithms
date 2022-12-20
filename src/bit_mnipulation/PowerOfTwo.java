package bit_mnipulation;

public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        int m = n;
        int c = 1;
        while (m > 1) {
            m = m >> 1;
            c = c << 1;
        }
        return n == c;
    }
}
