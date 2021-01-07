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

    // another way
    public int findPoisonedDuration_2(int[] timeSeries, int duration) {
        int output = 0;
        if(timeSeries == null || timeSeries.length == 0 || duration == 0) return output;
        int start = timeSeries[0], end = timeSeries[0] + duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if(timeSeries[i] > end){
                output += end - start;
                start = timeSeries[i];
            }
            end = timeSeries[i] + duration;
        }
        output += end - start;
        return output;
    }
}
