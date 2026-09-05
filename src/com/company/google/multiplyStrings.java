package com.company.google;

public class multiplyStrings {
    public String multiply(String num1, String num2) {
        StringBuilder rs = new StringBuilder();
        int m = num1.length();
        for(int i=m-1;i>=0;i--){
            StringBuilder s = multiply(num1.charAt(i), num2);
            s.append("0".repeat(m-i-1));
            System.out.println(s);
            if(rs.isEmpty()){
                rs.append(s);
            }else{
                rs = add(rs.toString(),s.toString());
            }
        }
        if(rs.length() > 1){
            int i = 0;
            while(rs.length() > 1){
                if(rs.charAt(i) == '0'){
                    rs.deleteCharAt(i);
                }else{
                    break;
                }
            }
        }
        return rs.toString();
    }

    private StringBuilder multiply(char ch, String num){
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = num.length()-1;i>=0;i--){
            int num1 = ch - '0';
            int num2 = num.charAt(i)-'0';
            int mult =num1*num2 + carry;
            sb.append(mult%10);
            carry = mult/10;
        }
        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse();
    }

    private StringBuilder add(String num1, String num2){
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i =num1.length(), j=num2.length();
        while(i>=0 || j>=0){
            int digit1 =0, digit2=0;
            if(i>=0){
                digit1 = num1.charAt(i--)-'0';
            }
            if(j>=0){
                digit2 = num2.charAt(j--)-'0';
            }
            int sum = digit1 + digit2 + carry;
            sb.append(sum%10);
            carry = sum/10;
        }
        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse();
    }
}
