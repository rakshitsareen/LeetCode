package com.leetcode;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

	public static String removeDuplicates(String s) {
		if (s == null || s.length() <= 1)
			return s;
		Stack<Character> st = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		st.push(s.charAt(0));
		for (int i = 1; i < s.length(); ++i) {
			if (!st.isEmpty() && s.charAt(i) == st.peek()) {
				st.pop();
			} else
				st.push(s.charAt(i));
		}
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abbakkkxkkkca"));
	}

}
