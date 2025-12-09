package com.company.bits;

public class addBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = 0;
            if(i >= 0) {
                sum = a.charAt(i--) - '0';
            }
            if(j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sum += carry;
            if(sum > 1) {
                carry = 1;
            } else {
                carry = 0;
            }
            res.append(sum % 2);
        }
        if(carry == 1) {
            res.append("1");
        }
        return res.reverse().toString();
    }
}
