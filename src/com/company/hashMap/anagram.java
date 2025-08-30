package com.company.hashMap;

import java.util.HashMap;

public class anagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            } else {
                if (map.get(t.charAt(i)) == 0) {
                    return false;
                }
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        for(Character c : map.keySet()) {
            if (map.get(c) > 0) {
                return false;
            }
        }
        return true;
    }
}
