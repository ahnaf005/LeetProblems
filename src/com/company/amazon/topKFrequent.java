package com.company.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        int count = 0;
        int cur = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]==cur){
                count++;
            }else{
                pq.offer(new int[]{cur,count});
                cur = nums[i];
                count = 0;
            }
        }
        pq.offer(new int[]{cur,count});
        int[] res = new int[k];
        int i = 0;
        while(k>0){
            res[i++] = pq.poll()[0];
            k--;
        }
        return res;
    }
}
