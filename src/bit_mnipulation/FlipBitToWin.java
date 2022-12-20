package bit_mnipulation;

import java.util.Arrays;

public class FlipBitToWin {
    public static int get(int n) {
        int[] bits = new int[32];
        int index = 31;
        while (n > 0) {
            bits[index] = n & 1;
            n = n >> 1;
            index--;
        }

        Arrays.fill(bits,1);

        System.out.printf("Byte Array: %s%n",Arrays.toString(bits));

        index = 0;
        for ( ; index < 32 && bits[index] != 1; index++);

        int count = 0, back = 0,max = 0;
        for (;index < 32; index++) {
            if (back == 0 && bits[index] == 1) {
                count++;
            }else if (back >= 1 && bits[index] == 1) {
                back++;
                count++;
            } else {
                if (back == 0) {
                    count++;
                    back++;
                }else {
                    max = Math.max(max,count);
                    count = back;
                    back = 1;
                    //System.out.printf("(M,C,B) = (%d,%d,%d)%n____________________%n",max,count,back);
                }
            }
        }
        max = Math.max(max,count);
        //System.out.printf("(M,C,B) = (%d,%d,%d)%n____________________%n",max,count,back);
        return max;
    }

    public static int usingBit(int n) {
        if (~n == 0) return 32;
        int max = 0,counter = 0, back = 0;
        while (n != 0) {
            int bit = n & 1;
            if (back == 0 && bit == 1) {
                counter++;
            }else if (back >= 1 && bit == 1) {
                counter++;
                back++;
            }else {
                if (back == 0) {
                    back++;
                    counter++;
                }else {
                    max = Math.max(max,counter);
                    counter = back;
                    back = 1;
                }
            }
            n = n >> 1;
        }
        return Math.max(max,counter);
    }
}
