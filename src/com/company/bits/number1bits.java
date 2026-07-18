package com.company.bits;

public class number1bits {
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for(int i = 1; i <= 31; i++){
            if((mask & n) != 0) {
                count++;
            }
            mask = mask << 1;
        }
        return count;
    }
}
