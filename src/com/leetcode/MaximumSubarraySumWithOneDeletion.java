package com.leetcode;

public class MaximumSubarraySumWithOneDeletion {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[] maxStartHere = new int[n], maxEndHere = new int[n];
        int max = arr[0];
        maxEndHere[0] = arr[0];
        for(int i = 1; i < n; ++i){
            maxEndHere[i] = Math.max(arr[i], arr[i] + maxEndHere[i-1]);
            max = Math.max(max, maxEndHere[i]);
        }
        maxStartHere[n-1] = arr[n-1];
        for(int i = n - 2; i >= 0; --i){
            maxStartHere[i] = Math.max(arr[i], maxStartHere[i + 1] + arr[i]);
        }
        for(int i = 1; i < n-1; ++i){
            max = Math.max(max, maxEndHere[i-1] + maxStartHere[i+1]);
        }
        return max;
    }
}
