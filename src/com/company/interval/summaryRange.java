package com.company.interval;

import java.util.ArrayList;
import java.util.List;

public class summaryRange {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int low = 0;
        List<String> res = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                String temp;
                if (i - low > 1) {
                    temp = nums[low] + "->" + nums[i - 1];
                } else{
                    temp = String.valueOf(nums[low]);
                }
                res.add(temp);
                low = i;
            }
        }
        if (low == nums.length - 1) {
            res.add(String.valueOf(nums[low]));
        }else{
            res.add(nums[low] + "->" + nums[nums.length - 1]);
        }
        return res;
    }
}
