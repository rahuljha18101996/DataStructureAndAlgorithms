package bit_mnipulation;

public class CheckPalindromicBit {
    /*
    * Positive Number Only
    * Algorithm:
    * Counting the bits
    * //Reversing the number now
    * Looping from 0 to bits
    * getting last bit
    * sifting (bits - 1 - i) times and doing or
    * checking if number = new number
    * */
    public static boolean isPalindrome(int n) {
        int m = n;
        int bits = 0;
        do {
            bits++;
        } while ((m = m >> 1) != 0);

        for (int i = 0; i < bits; i++) {
            int bit = (n >> i) & 1;
            m = m | (bit << (bits - 1 - i));
        }
        return n == m;
    }
}
