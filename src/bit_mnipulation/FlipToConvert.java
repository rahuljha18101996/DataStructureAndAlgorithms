package bit_mnipulation;

public class FlipToConvert {
    public static int count(int n, int m) {
        if (n == m) return 0;
        if (n < m) return count(m,n);
        int count = 0;
        while (m != 0) {
            int b0 = m & 1;
            int b1 = n & 1;
            if (b0 != b1) count++;
            m = m >> 1;
            n = n >> 1;
        }
        while (n != 0) {
            count++;
            n = n >> 1;
        }
        return count;
    }

    public static int optimize(int n,int m) {
        //Remove similar bits
        int i = n ^ m;
        //Now count 1
        int count = 0;
        while (i != 0){
            count++;
            i = i & (i - 1);
        }
        return count;
    }
}
