package com.company.string;

import java.util.Arrays;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char[] chArr1=s.toCharArray();
        char[] chArr2=t.toCharArray();
        Arrays.sort(chArr1);
        Arrays.sort(chArr2);
        for(int i=0;i<s.length();i++){
            if(chArr1[i]!=chArr2[i])
                return false;
        }
        return true;
    }
}
