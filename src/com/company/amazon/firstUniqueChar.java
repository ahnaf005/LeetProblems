package com.company.amazon;

import java.util.Arrays;

public class firstUniqueChar {
    public int firstUniqChar(String s) {
        int [] index = new int[26];
        Arrays.fill(index,-1);
        for (int i = 0; i < s.length(); i++) {
            if (index[s.charAt(i) - 'a'] >= 0) {
                index[s.charAt(i) - 'a'] = -2;
            }else if(index[s.charAt(i) - 'a'] == -1){
                index[s.charAt(i) - 'a'] = i;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if(index[i] >= 0){
                min = Math.min(min, index[i]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
