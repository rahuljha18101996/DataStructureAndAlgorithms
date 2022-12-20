package bit_mnipulation;

public class ReverseBits {
    /*
    * Algorithm:
    * Integer number consist of 32 Bits
    * Loop i from (0,31)
    * getting last bit by shifting i times and doing & with 1
    * sifting (bits - 1 - i) times and doing or
    * */

    public static int reverse(int n) {
        int res=0;
        for (int i=0; i < 32; i++){
            int bit= (n >> i) & 1;
            res = res | (bit << (31 - i));
        }
        return res;
    }
}
