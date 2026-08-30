package com.company.Dp1D;

import java.util.HashMap;

public class maxpoints {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer,Integer>points = new HashMap<>();
        int maxNumber = 0;
        for(int num:nums){
            points.put(num, points.getOrDefault(num,0) + num);
            maxNumber = Math.max(num, maxNumber);
        }
        int[] dp = new int[maxNumber+1];
        dp[0] = 0;
        dp[1] = points.getOrDefault(1 , 0);
        for(int i=2;i<=maxNumber;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+ points.getOrDefault(i, 0));
        }
        return dp[maxNumber];
    }
}
