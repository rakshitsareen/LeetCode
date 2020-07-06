package com.leetcode;

public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] A, int K) {
        int res = 0;
        if(K < 0) return res;
        int i = 0;
        for (int j = 0; j < A.length; j++) {
            if(A[j] == 0) K--;
            while(K < 0){
                if(A[i] == 0) K++;
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(arr, 3));
    }
}
