package com.company.string;

public class RepeatedSubsString {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int divider = 2;
        while (divider <= n) {
            if (n % divider == 0) {
                int subStrLen = n / divider;
                String str = "";
                String subStr = s.substring(0, subStrLen);
                for (int i = 0; i < divider; i++) {
                    str = str.concat(subStr);
                }
                if (s.equals(str))
                    return true;
            }
            divider += 2;
        }
        return false;
    }
}
