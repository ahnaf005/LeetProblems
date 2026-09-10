package com.company.google;

import java.util.*;

record pair(double ratio, int quality){
}
public class hireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<pair>list=new ArrayList<>();
        for(int i=0;i<quality.length;i++){
            double ratio= (double) wage[i] /quality[i];
            list.add(new pair(ratio,quality[i]));
        }
        list.sort(Comparator.comparingDouble(pair::ratio));
        PriorityQueue<Integer>queue=new PriorityQueue<>(Collections.reverseOrder());
        double totalCost = Integer.MAX_VALUE;
        int currentQuality=0;
        for(int i=0;i<list.size();i++){
            queue.add(list.get(i).quality());
            currentQuality+=list.get(i).quality();
            if(queue.size()>k){
                currentQuality -= queue.poll();
            }
            if(queue.size() == k){
                totalCost = Math.min(totalCost, currentQuality * list.get(i).ratio());
            }
        }
        return totalCost;
    }
}
