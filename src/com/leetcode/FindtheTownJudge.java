package com.leetcode;

public class FindtheTownJudge {
	public int findJudge(int N, int[][] trust) {
		if (trust.length < N - 1)
			return -1;
		int[] scores = new int[N + 1];
		for (int[] rel : trust) {
			scores[rel[0]]--;
			scores[rel[1]]++;
		}
		for (int i = 1; i <= N; ++i) {
			if (scores[i] == N - 1)
				return i;
		}
		return -1;
	}
}
