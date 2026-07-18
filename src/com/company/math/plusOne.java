package com.company.math;

public class plusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from the end
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;     // simple increment
                return digits;   // no carry needed
            }
            digits[i] = 0;        // set to 0 and continue carry
        }

        // If all digits were 9, we need a bigger array
        int[] res = new int[n + 1];
        res[0] = 1;  // e.g., 999 + 1 = 1000
        return res;
    }

}
