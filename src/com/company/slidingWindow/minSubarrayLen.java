package com.company.slidingWindow;

public class minSubarrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while(sum >= target) {
                len = Math.min(len, i - start + 1);
                sum -= nums[start];
                start += 1;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
