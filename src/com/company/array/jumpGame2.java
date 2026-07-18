package com.company.array;

public class jumpGame2 {
    public int jump(int[] nums) {
        int curEnd = 0, curFar = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFar = Math.max(curFar,i + nums[i]);
            if(i == curEnd){
                curEnd = curFar;
                count++;
            }
        }
        return count;
    }
}
