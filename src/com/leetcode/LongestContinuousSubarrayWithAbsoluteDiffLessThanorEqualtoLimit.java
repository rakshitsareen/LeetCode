package com.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
    public int longestSubarray(int[] nums, int limit) {
        int i = 0, j = 0;
        int res = 0;
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>((a,b) -> b - a);
        while (j < nums.length){
            min.offer(nums[j]);
            max.offer(nums[j]);
            Integer lo = min.peek();
            Integer hi = max.peek();
            if(hi - lo > limit){
                res = Math.max(res, j - i);
            }
            j++;
        }
        return res;
    }
}
