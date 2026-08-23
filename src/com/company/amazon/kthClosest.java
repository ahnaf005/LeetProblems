package com.company.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class kthClosest {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[1]));
        int index =0;
        for (int[] p : points) {
            double distance = Math.sqrt(p[0]*p[0] + p[1]*p[1]);
            pq.offer(new double[]{index++,distance});
        }
        List<int []> res = new ArrayList<>();
        while(k>0){
            int idx = (int)pq.poll()[0];
            res.add(new int[]{points[idx][0],points[idx][1]});
            k--;
        }
        return res.toArray(new int[res.size()][]);
    }
}
