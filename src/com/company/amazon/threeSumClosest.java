package com.company.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSumClosest {
    public int threeSum(int[] nums , int target) {
        Arrays.sort(nums);
        int res = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int tmp = twoSum(nums, i, target);
            if(Math.abs(target-tmp) < diff){
                diff = Math.abs(target-tmp);
                res = tmp;
            }
        }
        return res;
    }

    public int twoSum(int[] nums, int first, int target) {
        int left = first + 1, right = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        int res = 0;
        while (left < right){
            int sum = nums[left] + nums[right] + nums[first];
            if (sum == target){
                return sum;
            } else {
                if(Math.abs(target-sum) < diff){
                    diff = Math.abs(target-sum);
                    res = sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
