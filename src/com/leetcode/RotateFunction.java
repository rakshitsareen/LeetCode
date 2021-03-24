package com.leetcode;

public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int sum = 0, F = 0;
        for(int i = 0; i < A.length; ++i){
            sum += A[i];
            F += i * A[i];
        }
        int max = F;
        for(int i = A.length - 1; i >= 1; --i){
            F  = F + sum - A.length * A[i];
            max = Math.max(max, F);
        }
        return max;
    }
}
