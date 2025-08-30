package com.company.hashMap;

import java.util.HashMap;

public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> reverseMap = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i)) && !reverseMap.containsKey(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
                reverseMap.put(t.charAt(i), s.charAt(i));
            } else if(t.charAt(i) != map.getOrDefault(s.charAt(i), ' ') ||
                    s.charAt(i) != reverseMap.getOrDefault(t.charAt(i), ' ')) {
                return false;
            }
        }
        return true;
    }
}
