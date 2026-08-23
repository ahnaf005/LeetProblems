package com.company.amazon;

import java.util.ArrayList;
import java.util.List;

public class partitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] lastPos = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            lastPos[ch - 'a'] = i;
        }
        int end = 0;
        int size = 0;
        List<Integer>res = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            size++;
            char ch = s.charAt(i);
            end = Math.max(end,lastPos[ch-'a']);
            if(i == end){
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
