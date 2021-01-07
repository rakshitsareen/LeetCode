package com.leetcode;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        if (n == 0) return 0;
        int output = 0;
        for(int i = 0; i < n - 1; ++i){
            output += Math.min(timeSeries[i+1] - timeSeries[i], duration);
        }
        return output + duration;
    }
}
