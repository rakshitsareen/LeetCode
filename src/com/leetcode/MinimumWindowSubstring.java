package com.leetcode;

public class MinimumWindowSubstring {

	private char[] patternTable = new char[256];	//frequencies for characters in the pattern
	private char[] count = new char[256]; // array for pattern seen till now.

	public String minWindow(String s, String t) {
		/*
		 * s - source t - pattern to be found;
		 */
		int minLen = Integer.MAX_VALUE;
		int len = 0;
		int st = 0;
		int start = 0;
		int tLen = t.length();
		int sLen = s.length();
		if (tLen > sLen) {
			return new String("");
		}
		if (tLen == sLen && sLen == 1) {
			if (s.charAt(0) == t.charAt(0)) {
				return new String(s);
			}
			else 
				return new String("");
		}
		for (int i = 0; i < tLen; i++) {
			patternTable[t.charAt(i) - 'A']++; // counting all the frequencies
												// in the pattern.
		}

		for (int i = 0; i < sLen; i++) {
			if (patternTable[s.charAt(i) - 'A'] > 0) {
				if ((count[s.charAt(i) - 'A'] < patternTable[s.charAt(i) - 'A']) && len < tLen)
					len++;
				count[s.charAt(i) - 'A']++;
			}

			while (st < i && (patternTable[s.charAt(st) - 'A'] == 0
					|| count[s.charAt(st) - 'A'] > patternTable[s.charAt(st) - 'A'])) {
				count[s.charAt(st) - 'A']--;
				st++;
			}
			if (tLen == len && i - st + 1 < minLen) {
				minLen = i - st + 1;
				start = st;
			}
		}
		System.out.println(start);
		System.out.println(minLen);
		String ans = s.substring(start, start + minLen);
		if (len < tLen) {
			return new String("");
		}
		return ans;
	}

	public static void main(String[] args) {

		MinimumWindowSubstring sol = new MinimumWindowSubstring();
		String S = "a";
		String T = "b";
		System.out.println(sol.minWindow(S, T));
	}
}
