package com.leetcode;

public class GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        int N = A.length;
        for(int i = 0; i < N; ++i){
            if(Math.abs(A[i] - i) > 1) return false;
        }
        return true;
    }
}
