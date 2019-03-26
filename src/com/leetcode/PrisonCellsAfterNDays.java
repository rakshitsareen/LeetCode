package com.leetcode;

import java.util.Arrays;

public class PrisonCellsAfterNDays {

	public static int[] prisonAfterNDays(int[] cells, int N) {
		int[] first_copy = new int[cells.length];
		int[] workingCopy = new int[cells.length];
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < cells.length - 1; j++)
				workingCopy[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
			if (0 == i)
				first_copy = workingCopy.clone();
			else if (Arrays.equals(first_copy, workingCopy))
				N %= i;
			cells = workingCopy.clone();
		}
		return cells;
	}

	public static void main(String[] args) {
		int[] cells = new int[] { 0, 1, 0, 1, 1, 0, 0, 1 };
		int[] solution = prisonAfterNDays(cells, 7);
		for (int i : solution)
			System.out.print(i + ", ");
	}
}