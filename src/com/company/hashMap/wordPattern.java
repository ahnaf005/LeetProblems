package com.company.hashMap;

import java.util.HashMap;

public class wordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> reverseMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if(!map.containsKey(ch) && !reverseMap.containsKey(word)) {
                map.put(ch, word);
                reverseMap.put(word, ch);
            } else if(!word.equals(map.get(ch)) ||
                    ch != reverseMap.getOrDefault(word, ' ')) {
                return false;
            }
        }
        return true;
    }
}
