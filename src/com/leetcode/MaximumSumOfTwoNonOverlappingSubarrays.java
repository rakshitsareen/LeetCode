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

    public int maxSumTwoNoOverlap_slidingWindow(int[] A, int L, int M) {
        return Math.max(helper(A, L, M), helper(A, M, L));
    }

    private int helper(int[] A, int L, int M){
        int sumL = 0, sumM = 0;
        for(int i = 0; i < L + M; i++){
            if(i < L) sumL += A[i];
            else sumM += A[i];
        }
        int ans = sumL + sumM;
        int maxL = sumL;
        for(int i = L + M; i < A.length; i++){
            sumL += A[i - M] - A[i - M - L];
            sumM += A[i] - A[i - M];
            maxL = Math.max(maxL, sumL);
            ans = Math.max(ans, maxL + sumM);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr = {1,0,3};
        MaximumSumOfTwoNonOverlappingSubarrays sol = new MaximumSumOfTwoNonOverlappingSubarrays();
        System.out.println(sol.maxSumTwoNoOverlap_slidingWindow(arr,1,2));
    }
}
