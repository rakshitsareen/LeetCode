package com.leetcode;

import java.util.Stack;

public class LicenseKeyFormatting {

	public static String licenseKeyFormatting(String S, int K) {
		String[] split = S.split("-");
		StringBuilder s = new StringBuilder();
		Stack<StringBuilder> st = new Stack<>();
		for (String tmp : split)
			s.append(tmp);
		s = s.reverse();
		int i = 0;
		while (i < s.length()) {
			StringBuilder stemp = new StringBuilder();
			int remlen = s.length() - i;
			int len = remlen <= K ? remlen : K;
			stemp.append(s.substring(i, i + len));
			st.push(stemp.reverse());
			i += K;
		}
		s = new StringBuilder();
		while (!st.isEmpty()) {
			s.append(st.peek());
			st.pop();
			if (!st.isEmpty())
				s.append("-");
		}
		return s.toString().toUpperCase();
	}

	public static void main(String[] args) {
		String S = "2-5g-3-J";
		int K = 2;
		System.out.println(licenseKeyFormatting(S, K));
	}

}
