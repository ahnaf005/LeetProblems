package com.company.binarySearch;

public class MinSpeedSearch {
    public double timeRequired(int[] dist, int spd){
        double time=0;
        double speed=spd;
        for(int i=0;i< dist.length;i++){
            time+=(i==dist.length-1)?(double) dist[i]/speed:Math.ceil((double) dist[i]/speed);
        }
        return time;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int left=1;
        int right=10000000;
        int minspeed=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(timeRequired(dist,mid)<=hour){
                minspeed=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return minspeed;
    }
}
