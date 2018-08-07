package com.leetcode;

public class GoogleSolutionTwo {

	public int solution(int[] flowers, int k, int m) {

		int[] days = new int[flowers.length];
		for (int i = 0; i < flowers.length; i++) {
			days[flowers[i] - 1] = i + 1;
		}
		for (int i = 0; i < days.length; i++)
			System.out.print(days[i] + " ");

		return -1;
	}

	public static void main(String[] args) {
		GoogleSolutionTwo ans = new GoogleSolutionTwo();
		 int[] f = { 1, 2, 7, 6, 4, 3, 5 };
		ans.solution(f, 2, 2);
	}

}
