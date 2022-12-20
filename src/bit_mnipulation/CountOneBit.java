package bit_mnipulation;

public class CountOneBit {
    /*
     * Algorithm1 :
     * Iterate over number until it becomes 0
     * get last bit of number by doing & operation with 1
     * right shifting the digits of n by 1
     *
     * why n & 1 returns last bit ?
     * suppose n = 5, 5 in binary form is 101
     * 101 & 1 = 101 & 001 = 1
     * */
    public static int numberOfOneBitUsingAlgo1(int n) {
        int one_bit_counter = 0;
        do {
            one_bit_counter += (n & 1);
        } while ((n = n >> 1) != 0);
        return  one_bit_counter;
    }

    /*
    * Algorithm2:
    * bits = 0
    * Iterate over number until it becomes 0
    * increment bit
    * n = n & (n - 1)
    *
    * What is (n & n -1) ?
    * Reducing 1 last bit to 0.
    * Suppose n = 7, 7 in binary 111
    * n - 1 = 6, 6 in binary 110
    * n & (n -1) = 110
    * */
    public static int numberOfOneBitUsingAlgo2(int n) {
        int one_bit_counter = 0;
         do {
             one_bit_counter++;
         } while ((n &= n - 1) != 0);
         return one_bit_counter;
    }
}
