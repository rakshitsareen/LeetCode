package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralPrint {

	public static List<Integer> spiralPrint(int rows, int cols, int[][] a) {
		List<Integer> ans = new ArrayList<>();
		int i, k = 0, l = 0;
		// k - starting row index
		// rows - ending row index
		// l - starting column index
		// cols - ending column index
		// i - iterator
		while (k < rows && l < cols) {

			// print the first row
			for (i = l; i < cols; i++) {
				// System.out.println(a[k][i]);
				ans.add(a[k][i]);
			}
			k++;

			// print the last column
			for (i = k; i < rows; i++) {
				// System.out.println(a[i][cols - 1]);
				ans.add(a[i][cols - 1]);
			}
			cols--;
			if (k < rows) {
				// print the ending row
				for (i = cols - 1; i >= l; --i) {
					// System.out.println(a[rows - 1][i]);
					ans.add(a[rows - 1][i]);
				}
				rows--;
			}

			if (l < cols) {
				// print the first column
				for (i = rows - 1; i >= k; --i) {
					// System.out.println(a[i][l]);
					ans.add(a[i][l]);
				}
				l++;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int R = 3;
		int C = 6;
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		List<Integer> res = spiralPrint(R, C, a);
		for (int i : res)
			System.out.print(i + " ");
	}

}
