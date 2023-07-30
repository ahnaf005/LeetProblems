package com.company.array;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        int h=0;
        Arrays.sort(citations);
        int lastItem=-1;
        for(int i=0;i<citations.length;i++){
            if(lastItem==citations[i]){
                continue;
            }
            lastItem=citations[i];
            int hTemp=Math.min(citations[i],citations.length-i);
            if(hTemp>h){
                h=hTemp;
            }
        }
        return h;
    }

    public int hIndex2(int[] citations) {
        // sorting the citations in ascending order
        Arrays.sort(citations);
        // finding h-index by linear search
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i; // after the while loop, i = i' + 1
    }

    
}
