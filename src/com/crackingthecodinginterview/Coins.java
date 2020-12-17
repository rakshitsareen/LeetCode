package com.crackingthecodinginterview;

import java.util.Arrays;

public class Coins {

	public static long countWays(int[] S, int m, int n) {
		long[] table = new long[n + 1];

		Arrays.fill(table, 0);

		table[0] = 1;

		for (int i = 0; i < m; i++)
			for (int j = S[i]; j <= n; j++)
				table[j] += table[j - S[i]];
		//System.out.println(table[n]);
		return table[n];
	}

	public static void main(String[] args) {
		int[] arr = { 25, 10, 5, 1 };
		int m = arr.length;
		int n = 100;
		// countWays(arr, m, n);
		System.out.println(countWays(arr, m, n));
	}

}
