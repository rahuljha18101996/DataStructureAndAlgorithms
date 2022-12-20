package bit_mnipulation;

public class PairwiseSwap {
    //Algorithm:
    //Create a mask with alternate 1 and 0
    //0xAAAAAAAA -> 10101010101010101010101010101010
    //0x55555555 ->   01010101010101010101010101010101
    //Preserve bits using both shift them and or them
    public static int swap(int n) {
        return ((n & 0xAAAAAAAA) >> 1) | ((n & 0x55555555) << 1);
    }
}
