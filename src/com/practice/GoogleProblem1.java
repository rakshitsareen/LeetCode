package com.practice;

public class GoogleProblem1 {

	public static int solution(String A, String B) {
		if (A == null || B == null)
			return -1;
		StringBuilder result = new StringBuilder();
		int a = A.length();
		int b = B.length();
		if (b < a) {
			return -1;
		}
		if (a == 0 & b == 0)
			return 0;
		if (a == 0 & b > 0)
			return -1;
		int rep = (int) (b / a + 1);
		int counter = 0;
		while (rep >= 0) {
			result = result.append(A);
			counter++;
			if (result.toString().contains(B))
				return counter;
			rep--;
		}
		if (result.toString().contains(B))
			return counter;
		else
			return -1;
	}

	public static void main(String[] args) {
		System.out.println(solution(null, "1234512"));
	}

}
