package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        int result = 0;
        if(points == null || points.length == 0) return result;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < points.length; ++i){
            map.clear();
            int overlap = 0, max = 0;
            for(int j = i + 1; j < points.length; ++j){
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if(x == 0 && y == 0) {overlap++; continue;}
                int g = generateGCD(x,y);
                if(g != 0){
                    x/=g;
                    y/=g;
                }
                if(map.containsKey(x)){
                    if(map.get(x).containsKey(y)){
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    }
                    else {
                        map.get(x).put(y,1);
                    }
                }else {
                    Map<Integer, Integer> m = new HashMap<>();
                    m.put(y,1);
                    map.put(x,m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }

    private int generateGCD(int x, int y){
        if(y == 0) return x;
        else return generateGCD(y, x%y);
    }
}
