package com.leetcode;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        boolean[] isTravelDay = new boolean[lastDay + 1];
        for(int day: days) isTravelDay[day] = true;
        dp[0] = 0;
        for(int i = 1;i <= lastDay; ++i){
            if(!isTravelDay[i]){
                dp[i] = dp[i-1];
                continue;
            }
            dp[i] = dp[i-1] + costs[0];
            dp[i] = Math.min(dp[i], costs[1] + dp[Math.max(0, i-7)]);
            dp[i] = Math.min(dp[i], costs[2] + dp[Math.max(0, i-30)]);
        }
        return dp[lastDay];
    }
}
