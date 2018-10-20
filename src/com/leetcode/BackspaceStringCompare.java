package com.leetcode;

public class BackspaceStringCompare {

	public String buildString(String s) {
		// TODO : Tried this approach, but takes extra space
		int rightmost = 0, leftmost = 0, middle = 0;
		while (rightmost < s.length() && s.charAt(rightmost) == '#') {
			rightmost++;
			leftmost++;
		}
		StringBuilder sb = new StringBuilder();
		while (rightmost < s.length()) {
			if (s.charAt(rightmost) != '#') {
				middle = rightmost;
				rightmost++;
			} else if (s.charAt(rightmost) == '#') {
				while (rightmost < s.length() && s.charAt(rightmost) == '#') {
					rightmost++; // move forward in the string
					if (middle >= 0) {
						middle--; // delete the previous characters
						while (middle >= 0 && s.charAt(middle) == '#') // now if we end up at '#' again, then move
																		// backwards
							middle--;
					}
				}
				// save the string, reset leftmost and start again
				if (leftmost < s.length() && middle + 1 < s.length() && middle >= leftmost) {
					sb.append(s.subSequence(leftmost, middle + 1));
				} else {
					System.out.println(s.charAt(middle));
				}
				leftmost = rightmost;
			}
		}
		if (leftmost < s.length() && middle + 1 <= s.length())
			sb.append(s.subSequence(leftmost, middle + 1));
		return sb.toString();
	}

	public boolean backspaceCompare(String S, String T) {
		int i = S.length() - 1, j = T.length() - 1;
		int skip_s = 0, skip_t = 0;
		while (i >= 0 || j >= 0) {
			while (i >= 0) {
				if (S.charAt(i) == '#') {
					skip_s++;
					i--;
				} else if (skip_s > 0) {
					skip_s--;
					i--;
				} else
					break;
			}
			while (j >= 0) {
				if (T.charAt(j) == '#') {
					skip_t++;
					j--;
				} else if (skip_t > 0) {
					skip_t--;
					j--;
				} else
					break;
			}
			if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
				return false;
			if ((i >= 0) != (j >= 0))
				return false;
			i--;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		// System.out.println(new BackspaceStringCompare().getString("bxj##tw"));
		// System.out.println(new BackspaceStringCompare().buildString("abxo##j##tw"));
		System.out.println(new BackspaceStringCompare().backspaceCompare("bxj##tw", "bxo#j##tw"));
	}
}
