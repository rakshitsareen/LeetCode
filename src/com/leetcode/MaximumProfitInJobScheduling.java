package com.leetcode;

import com.sun.scenario.effect.Brightpass;

import javax.print.attribute.standard.JobSheets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumProfitInJobScheduling {
   static  class Job {
        int start, end, profit;
        public Job(int start, int end, int profit){
            this.end = end;
            this.start = start;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        Job[] jobs = new Job[n];
        for(int i = 0; i < n; ++i){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.end));
        List<Integer> jobEnds = new ArrayList<>();
        List<Integer> dp = new ArrayList<>();
        jobEnds.add(0); dp.add(0);
        for(Job job : jobs){
            int prevIdx = largestSmaller(jobEnds, job.start + 1);
            int profit1 = dp.get(prevIdx) + job.profit;
            int profit2 = dp.get(dp.size() - 1);
            if(profit1 > profit2){
                jobEnds.add(job.end);
                dp.add(profit1);
            }
        }
        return dp.get(dp.size() - 1);
    }

    private int largestSmaller(List<Integer> list, int target){
        int lo = 0, hi = list.size() - 1;
        while(lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;
            if(list.get(mid) < target) lo = mid;
            else hi = mid - 1;
        }
        return list.get(hi) < target ? hi : lo;
    }
}
