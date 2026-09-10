package com.company.google;

public class maxDistToClosest {
    public int maxDistToClosest(int[] seats) {
        int maxDist = Integer.MIN_VALUE;
        int n = seats.length;
        Integer occupiedSeat = null;
        for (int i = 0; i < n; i++) {
            if(seats[i] == 1){
                if(occupiedSeat == null){
                    if(i!=0) {
                        maxDist = i;
                    }
                }else{
                    maxDist = Math.max(maxDist, (i-occupiedSeat)/2);
                }
                occupiedSeat = i;
            }
        }
        if(maxDist < (n - occupiedSeat-1) && seats[n-1] == 0){
            maxDist = n-occupiedSeat-1;
        }
        return maxDist;
    }
}
