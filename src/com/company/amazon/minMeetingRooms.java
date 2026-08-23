package com.company.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class minMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxRooms = 0;

        for (int[] interval : intervals) {
            while (!pq.isEmpty() && pq.peek() <= interval[0]) {
                pq.poll();
            }

            pq.offer(interval[1]);
            maxRooms = Math.max(maxRooms, pq.size());
        }

        return maxRooms;
    }
}
