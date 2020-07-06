package com.leetcode;

public class BinarySubarraysWithSum {
    public static int numSubarraysWithSum(int[] A, int S) {
        return atMost(A,S) - atMost(A, S - 1);
    }

    private static int atMost(int[] A, int S){
        int res = 0;
        if(S < 0) return res;
        int i = 0;
        for(int j = 0; j < A.length; ++j){
            S -= A[j];
            while(S < 0){
                S += A[i];
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr = {1,0,1,0,1};
        System.out.println(numSubarraysWithSum(arr, 2));
    }
}
