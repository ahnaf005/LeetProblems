package com.company.hashMap;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class longestConSeq {
    public int longestConsecutive2(int[] nums) {
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

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        int currentStreak = 1;
        int currentNum = set.first();
        for(int num : set) {
            if(num == currentNum+1) {
                currentStreak++;
            }else{
                max = Math.max(max, currentStreak);
                currentStreak = 1;
            }
            currentNum = num;
        }
        max = Math.max(max,currentStreak);
        return max;
    }
}
