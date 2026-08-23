package com.company.amazon;

import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer>leftHeap;
    PriorityQueue<Integer>rightHeap;
    public MedianFinder() {
        leftHeap = new PriorityQueue<>((a,b)->b -a);
        rightHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        leftHeap.add(num);
        rightHeap.add(leftHeap.poll());
        if(leftHeap.size()<rightHeap.size()){
            leftHeap.add(rightHeap.poll());
        }
    }

    public double findMedian() {
        return leftHeap.size()>rightHeap.size()?leftHeap.peek() : (leftHeap.peek()+ rightHeap.peek())*0.5;
    }
}
