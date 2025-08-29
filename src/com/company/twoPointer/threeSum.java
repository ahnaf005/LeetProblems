package com.company.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            twoSum(nums, i, res);
        }
        return res;
    }

    public void twoSum(int[] nums, int first, List<List<Integer>> res) {
        int left = first + 1, right = nums.length - 1;
        while (left < right){
            int sum = nums[left] + nums[right] + nums[first];
            if (sum == 0){
                res.add(new ArrayList<>(Arrays.asList(nums[first], nums[left++], nums[right--])));
                while (left < right && nums[left] == nums[left - 1]) left++;
            } else if (sum < 0){
                left++;
            } else {
                right--;
            }
        }
    }
}
