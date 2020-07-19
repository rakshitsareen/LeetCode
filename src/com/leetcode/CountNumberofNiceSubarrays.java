package com.leetcode;

public class CountNumberofNiceSubarrays {
    public int numberOfSubarrays(int[] A, int k) {
        return atMost(A, k) - atMost(A , k-1);
    }

    private int atMost(int[] A, int k){
        int n = A.length, i = 0, res = 0;
        for(int j = 0; j < n; ++j){
            if(A[j] % 2 == 1) k--;
            while(k < 0){
                if(A[i]%2 ==1) k++;
                i++;
            }
            res += j-i+1;
        }
        return res;
    }
}
