package com.company.hashMap;

import java.util.HashSet;
import java.util.Set;

public class longestConSeq {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentStreak = 1;
                int currentNum = num;
                while (set.contains(currentNum + 1)) {
                    currentStreak++;
                    currentNum++;
                }
                max = Math.max(max, currentStreak);
            }
        }
        return max;
    }
}
