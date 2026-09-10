package com.company.google;

import java.util.ArrayList;
import java.util.List;

public class missingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int nextExpected = lower;
        List<List<Integer>> res = new ArrayList<>();
        for (int num : nums) {
            if (num == nextExpected) {
                nextExpected++;
            } else {
                res.add(new ArrayList<>(List.of(nextExpected, num - 1)));
                nextExpected = num + 1;
            }
        }
        if(nextExpected <= upper){
            res.add(new ArrayList<>(List.of(nextExpected, upper)));
        }
        return res;
    }
}
