package com.company.array;

import java.util.Arrays;

public class missingMultiple {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int multiply = 1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == k*multiply){
                multiply++;
            }else if(nums[i] > k*multiply){
                return k*multiply;
            }
        }
        return k*multiply;
    }
}
