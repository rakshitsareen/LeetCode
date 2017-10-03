package com.crackingthecodinginterview;

public class RecursiveMultiply {

	public int recMul(int a, int b) {
		if (b == 1)
			return a;
		return a + recMul(a, b - 1);
	}

	public int recMulMemo(int a, int b) {
		int bigger = a < b ? b : a;
		int smaller = a < b ? a : b;
		int memo[] = new int[smaller +1];
		return recMulMemoUtil(smaller, bigger, memo);
	}
	
	private int recMulMemoUtil(int smaller, int bigger, int [] memo) {
		if(smaller == 0) return 0;
		if(smaller == 1) return bigger;
		if(memo[smaller] > 0) return memo[smaller];
		//divide the subproblem into 2 parts.
		int s = smaller >> 1;
		int left = recMulMemoUtil(s, bigger, memo);
		int right = left;
		if(smaller % 2 == 1) right = recMulMemoUtil(smaller-s, bigger, memo);
		memo[smaller] = left + right;
		return memo[smaller];
	}

	public static void main(String[] args) {
		RecursiveMultiply sol = new RecursiveMultiply();
		System.out.println(sol.recMul(9, 7));
		System.out.println(sol.recMulMemo(9, 7));
	}
}
