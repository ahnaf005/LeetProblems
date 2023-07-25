package com.company.array;

public class RemoveDuplicateSorted2 {
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        int dup=0;
        int cur=0;
        while(cur< (len-dup-2)){
            if(nums[cur] == nums[cur+1] && nums[cur] == nums[cur+2]){
                for(int j=cur+2;j<(len-dup-1);j++){
                    int k=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=k;
                }
                dup++;
            }else{
                cur++;
            }
        }
        return len-dup;
    }

    public int removeDuplicates2(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int rindex=1;
        for(int i=2;i<nums.length;i++){
            int cur=nums[i];
            if(cur==nums[rindex] && cur==nums[rindex-1]){
                continue;
            }
            nums[++rindex]=cur;
        }
        return rindex+1;
    }
}
