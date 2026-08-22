package com.company.array;

public class gasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int curTank=0;
        int startIndex = 0;
        for(int i =0;i<gas.length;i++){
            curTank += gas[i]-cost[i];
            totalTank += gas[i]-cost[i];
            if(curTank<0){
                curTank = 0;
                startIndex = i+1;
            }
        }
        return totalTank>=0?startIndex:-1;
    }
}
