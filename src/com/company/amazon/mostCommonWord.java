package com.company.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class mostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[\"!?',;.]", " ");
        paragraph = paragraph.trim();
        String[] words = paragraph.split("\\s+");
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            String key = word.toLowerCase();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int max = 0;
        String mostCommonWord = "";
        Set<String> set = new HashSet<String>();
        for (String word : banned) {
            set.add(word.toLowerCase());
        }
        for(String word: map.keySet()){
            if(!set.contains(word) && max<map.get(word)){
                max = map.get(word);
                mostCommonWord = word;
            }
        }
        return mostCommonWord;
    }
}
