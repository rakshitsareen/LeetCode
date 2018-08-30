package com.leetcode; // DO NOT write this line

public class Eliquii {

	// this is the solution. you probably have to write this only
	public static void solution(String str, int start, int end) {
		if (start == end) {
			System.out.println(str);
		} else {
			for (int i = start; i <= end; i++) {
				str = swap(str, start, i);
				solution(str, start + 1, end);
				str = swap(str, start, i);
			}
		}
	}

	public static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	// you probably DO NOT have to write this also
	public static void main(String[] args) {
		String str = "abc";
		int n = str.length();
		Eliquii.solution(str, 0, n - 1);
	}

}
