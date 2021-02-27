package com.leetcode;


public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;
        while(a - b >= 0){
            int val = b;
            int qoutient = 1;
            while(a - (val << 1) >= 0){
                val <<= 1;
                qoutient <<= 1;
            }
            a -= val;
            res += qoutient;
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }
}
