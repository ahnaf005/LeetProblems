package com.company.google;

import java.util.HashMap;
import java.util.Map;

public class longestSubWithTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        int distinct = 0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            }else{
                map.put(s.charAt(right), 1);
                distinct++;
                if (distinct == 3) {
                    len = Math.max(len, right - left);
                    while(distinct == 3) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                        if(map.get(s.charAt(left)) == 0) {
                            distinct--;
                            map.remove(s.charAt(left));
                        }
                        left++;
                    }
                }
            }
            right++;
        }
        if(distinct < 3){
            len = Math.max(len, right - left);
        }
        return len;
    }
}
