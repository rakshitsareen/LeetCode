package com.leetcode;

public class MinimumWindowSubsequence {
	public String minWindow(String S, String T) {
		char[] s = S.toCharArray(), t = T.toCharArray();
		int sindex = 0, tindex = 0, slen = s.length, tlen = t.length, len = slen;
		int start = -1;
		while (sindex < slen) {
			if (s[sindex] == t[tindex]) {
				tindex++;
				if (tindex == tlen) {
					// go back so as to find sindex where tindex exhausts
					int end = sindex + 1;
					while (--tindex >= 0)
						while (s[sindex--] != t[tindex])
							;
					sindex++;
					tindex++;
					if (end - sindex < len) {
						len = end - sindex;
						start = sindex;
					}
				}
			}
			sindex++;
		}
		return start == -1 ? "" : S.substring(start, start + len);
	}
}
