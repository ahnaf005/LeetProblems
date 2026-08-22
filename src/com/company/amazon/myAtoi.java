package com.company.amazon;

public class myAtoi {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty())
            return 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        long res = 0;
        boolean isNegative = false;
        int i = 0;
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            i++;
            if(s.charAt(0) == '-'){
                isNegative = true;
            }
        }
        while(i< s.length() && Character.isDigit(s.charAt(i))){
            res = res*10 + (s.charAt(i) - '0');
            if(isNegative){
                if((-1)*res < min){
                    return min;
                }
            }else{
                if(res>max){
                    return max;
                }
            }
            i++;
        }
        return isNegative? (int)(-res) : (int)res;
    }
}
