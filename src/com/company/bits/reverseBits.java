package com.company.bits;

public class reverseBits {
    public int reverseBits(int n) {
        long res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;          // make space for next bit
            res |= (n & 1);     // add least significant bit of n
            n >>>= 1;           // unsigned shift right
        }
        return (int) res;
    }

}
