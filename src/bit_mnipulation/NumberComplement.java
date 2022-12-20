package bit_mnipulation;

class NumberComplement {
    public int findComplement(int num) {
        int k = 0,index = 0;
        while (num != 0) {
            int bit = num & 1;
            if (bit == 0) {
                k |= 1 << index;
            }
            index++;
            num = num >> 1;
        }

        return k;
    }
}
