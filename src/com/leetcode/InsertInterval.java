package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        List<int[]> result = new ArrayList<int[]>();
        int i = 0; 
        while(i < len && intervals[i][1] < newInterval[0]){
            result.add(intervals[i++]);
        }
        while(i < len && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            ++i;
        }
        result.add(newInterval);
        while(i < len) result.add(intervals[i++]);
        return result.toArray(new int[result.size()][2]);
    }
}
