package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] point : points){
            map.putIfAbsent(point[0], new HashSet<Integer>());
            map.get(point[0]).add(point[1]);
        }
        int ans = Integer.MAX_VALUE;
        for(int[] p1: points)
            for(int[] p2: points){
                if(p1[0] == p2[0] || p1[1] == p2[1]) continue;
                if(map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1]))
                    ans = Math.min(ans, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
            }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
}
