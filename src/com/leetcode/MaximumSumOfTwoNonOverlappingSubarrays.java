package com.leetcode;


public class MaximumSumOfTwoNonOverlappingSubarrays {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        for(int i = 1; i < A.length; ++i){
            A[i] += A[i-1];
        }
        return Math.max(maxSumTwoNoOverlap_helper(A, L, M), maxSumTwoNoOverlap_helper(A, M, L));
    }
    private int maxSumTwoNoOverlap_helper(int[] A, int L, int M) {
        int ans = A[L + M - 1]; // this needs to be set properly
        int maxL = A[L-1]; // this too
        for(int i = L + M; i < A.length; ++i){
            maxL = Math.max(maxL, A[i - M] - A[i - M - L]);
            ans = Math.max(ans, maxL + A[i] - A[i - M]);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {1,0,3};
        MaximumSumOfTwoNonOverlappingSubarrays sol = new MaximumSumOfTwoNonOverlappingSubarrays();
        System.out.println(sol.maxSumTwoNoOverlap(arr,1,2));
    }
}
