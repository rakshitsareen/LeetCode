package com.leetcode;

interface LambdaFunction {
	int op(int x, int y);
}

public class FirstLambda {

	public static void main(String[] args) {
		// LambdaFunction lf = () -> System.out.println("hello world");
		// lf.call();
		LambdaFunction lf = (x, y) -> x + y;
		System.out.println(lf.op(1, 2));
		lf = (x, y) -> x * y;
		System.out.println(lf.op(2, 3));
	}
}