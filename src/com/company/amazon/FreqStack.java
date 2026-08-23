package com.company.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

class FreqStack {

    Map<Integer,Integer> freqMap;
    Map<Integer, Stack<Integer>>group;
    int maxFreq;

    public FreqStack() {
        this.freqMap = new HashMap<>();
        this.group = new HashMap<>();
        this.maxFreq = 0;
    }

    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) +1;
        if(freq>maxFreq){
            maxFreq = freq;
        }
        freqMap.put(val,freq);
        group.computeIfAbsent(freq, z-> new Stack<>()).push(val);
    }

    public int pop() {
        int val = group.get(maxFreq).pop();
        freqMap.put(val, freqMap.get(val)-1);
        if(group.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        return val;
    }
}
