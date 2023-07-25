package com.company.string;

import java.util.Arrays;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int len1=s.length();
        int len2=t.length();
        char[] arr1=s.toCharArray();
        char[] arr2=t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i=0,j=0;
        while(i<len1 && j<len2){
            if(arr1[i]!=arr2[j]){
                return arr2[j];
            }
            i++;
            j++;
        }
        return arr2[j];
    }

    public char findTheDifference2(String s, String t) {
        int sum1=0,sum2=0;
        for(int i=0;i<s.length();i++){
            sum1+=s.charAt(i);
        }
        for(int i=0;i<t.length();i++){
            sum2+=t.charAt(i);
        }
        return (char) (sum2-sum1);
    }

    public char findTheDifference3(String s, String t) {
        char[] charArr1=s.toCharArray();
        char[] charArr2=t.toCharArray();
        for(int i=0;i<s.length();i++){
            charArr2[i+1]+=charArr2[i]-charArr1[i];
        }
        return charArr2[t.length()-1];
    }
}
