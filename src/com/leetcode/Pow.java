package com.leetcode;

public class Pow {

	public double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (n == Integer.MIN_VALUE)
			return myPow(x, -Integer.MAX_VALUE) * (1 / x);
		if (n < 0 && n > Integer.MIN_VALUE) {
			x = 1 / x;
			n = -n;
		}
		return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}
}
