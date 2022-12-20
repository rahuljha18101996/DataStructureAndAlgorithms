package bit_mnipulation;

public class BitOperation {
    /*
    * Algorithm 1:
    * (n >> (i_th - 1)) & 1
    * Shifting right required bit at the last, and doing & with 1 to get the bit
    *
    * Algorithm 2:
    * (n & (1 << i_th))
    * Concept : Make other bit 0 except required bit if number is 0 then return 0 otherwise 1
    * Shifting left 1 ith times and doing & with originla number
    * */

    public static int getBit(int n, int i_th) {
        return (n >> (i_th - 1)) & 1;
    }

    /*
    * Algorithm:
    * n | (1 << i_th)
    * doing |  with shifted 1 ith times
    * */
    public static int setBitAsOne(int n,int i_th) {
        return  n | (1 << i_th);
    }

    /*
    * Algorithm:
    * n & ~(1 << i_th)
    * doing &  with  shifted & negated 1 ith times
    * */
    public static int setBitAsZero(int n, int i_th) {
        return n & ~(1 << i_th);
    }

    /*
    * Algorithm:
    * (n & ~(1 << i_th)) | (bit << i_th)
    * Clearing the ith bit
    * Updating the bit
    * */
    public int  updateBit(int n,int i_th, int bit) {
        return (n & ~(1 << i_th)) | (bit << i_th);
    }
}
