package com.company.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class insertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length+1][2];
        boolean newIntervalAdded = false;
        for (int i = 0; i < intervals.length; i++) {
            newIntervals[i][0] = intervals[i][0];
            newIntervals[i][1] = intervals[i][1];
        }
        newIntervals[newIntervals.length-1][0] = newInterval[0];
        newIntervals[newIntervals.length-1][1] = newInterval[1];
        Arrays.sort(newIntervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int start = newIntervals[0][0], end = newIntervals[0][1];
        for (int i = 1; i < newIntervals.length; i++) {
            if (newIntervals[i][0] <= end) {
                end = Math.max(end, newIntervals[i][1]);
            } else {
                res.add(new int[]{start, end});
                start = newIntervals[i][0];
                end = newIntervals[i][1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}
