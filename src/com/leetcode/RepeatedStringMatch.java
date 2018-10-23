package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class RepeatedStringMatch {

	public static int repeatedStringMatch(String A, String B) {
		if(A.contains(B)) return 1;
		Set<Character> sa = new HashSet<>();
		Set<Character> sb = new HashSet<>();
		for (int i = 0; i < A.length(); i++)
			sa.add(A.charAt(i));
		for (int i = 0; i < B.length(); i++)
			sb.add(B.charAt(i));
		if (sa.size() != sb.size())
			return -1;
		double lenA = A.length();
		double lenB = B.length();
		int reps = (int) Math.ceil(lenB / lenA) + 1;
		StringBuilder stb = new StringBuilder();
		for (int i = 0; i < reps; i++) {
			stb.append(A);
			if (stb.toString().contains(B))
				return i + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(repeatedStringMatch("a", "aa"));
	}

}
