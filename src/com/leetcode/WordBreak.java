package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<String>(wordDict);
		if (s.length() == 1)
			return dict.contains(s);
		final int n = s.length();
		boolean[][] dp = new boolean[n][n];
		for (int i = 0; i < n; i++)
            dp[i][i] = dict.contains(s.substring(i, i + 1));
		for (int len = 2; len <= n; len++)
			for (int i = 0; i <= n - len; i++) {
				if (dict.contains(s.substring(i, i + len)))
					dp[i][i + len - 1] = true;
				else {
					for (int j = i; j < len; j++) {
						if (j + 1 < len)
							if (dp[i][j] && dp[j + 1][i + len - 1])
								dp[i][i + len - 1] = true;
					}
				}
			}
		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab";
		List<String> list = new ArrayList<String>();
		// list.add("apple");
		// list.add("pen");
		list.add("a");
		list.add("b");
		// list.add("sand");
		// list.add("and");
		// list.add("cat");
		System.out.println(new WordBreak().wordBreak(s, list));
	}

}
