package com.company.google;

import java.util.Deque;
import java.util.LinkedList;

public class plusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        Deque<Integer> stack = new LinkedList<>();
        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            stack.push(sum % 10);
            carry = sum / 10;
        }
        if(carry == 1){
            stack.push(1);
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
