package bit_mnipulation;

public class Insertion {
//    public static void main(String[] args) {
//        int i = 2;
//        int j = 6;
//        int n = 0b10000000000;
//        int m = 0b10011;
//        System.out.println(n);
//        System.out.println(m);
//
//        int allOne = ~0;
//        int mask = (allOne << (i + j)) | ((1 << i) - 1);
//        System.out.println(Integer.toBinaryString(mask));
//
//        int result = (n & mask) | (m << i);
//        System.out.println(Integer.toBinaryString(result));
//    }

    /*
    * Algorithm:
    * Removing the bits
    * adding the M
    * */

    public static int insert(int n,int m,int i,int j) {
        int allOne = ~0;
        int mask = (allOne << (i + j)) | ((1 << i) - 1);
        return (n & mask) | (m << i);
    }
}