package com.leetcode;


public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int k = costs[0].length;
        int n = costs.length;
        for(int house = 1; house < n; ++house){
            for(int color = 0; color < k; color++){
                int min = Integer.MAX_VALUE;
                for(int prevcolor = 0; prevcolor < k; ++prevcolor){
                    if(color == prevcolor) continue;
                    min = Math.min(min, costs[house - 1][prevcolor]);
                }
                costs[house][color] += min;
            }
        }
        int output = Integer.MAX_VALUE;
        for(int i = 0; i < k; ++i){
            output = Math.min(output, costs[costs.length - 1][i]);
        }
        return output;
    }
}
