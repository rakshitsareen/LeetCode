package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for(int row = 0; row < grid.length; ++row){
            for(int col = 0; col < grid[0].length; ++col) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        int r = rows.get(rows.size()/2);
        Collections.sort(cols);
        int c = cols.get(cols.size()/2);
        return midDistance1D(rows,r) + midDistance1D(cols, c);
    }
    private int midDistance1D(List<Integer> points, int origin){
        int res = 0;
        for(int p : points){
            res += Math.abs(p - origin);
        }
        return res;
    }
}
