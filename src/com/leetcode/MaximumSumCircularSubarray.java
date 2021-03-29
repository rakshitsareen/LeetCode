package com.leetcode;

public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] A) {
        int output = 0,  cur = 0;
        for (int j : A) {
            cur = j + Math.max(cur, 0);
            output = Math.max(output, cur);
        }

        int[] rightsums = new int[A.length];
        rightsums[A.length - 1] = A[A.length - 1];
        for(int i = A.length - 2; i >= 0; --i){
            rightsums[i] = rightsums[i+1] + A[i];
        }
        int[] maxrights = new int[A.length];
        maxrights[A.length - 1] = A[A.length - 1];
        for(int i = A.length - 2; i >= 0; --i){
            maxrights[i] = Math.max(maxrights[i+1],rightsums[i]);
        }
        int left = 0;
        for(int i = 0; i < A.length - 2; ++i){
            left += A[i];
            output = Math.max(output, left + maxrights[i+2]);
        }
        return output;
    }
}
