package com.leetcode;

interface Relation {
	boolean knows(int i, int j);
}

public abstract class FindtheCelebrity implements Relation {

	public int findCelebrity(int n) {	// my initial implementation
		int[] kno = new int[n];
		int[] onk = new int[n];
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j) {
				if (j == i)
					continue;
				if (knows(i, j)) {
					// System.out.println(i + " knows " + j);
					kno[j]++;
					onk[i]++;
				}
			}
		for (int i = 0; i < n; ++i)
			if (kno[i] == n - 1 && onk[i] == 0)
				return i;
		return -1;
	}

}
