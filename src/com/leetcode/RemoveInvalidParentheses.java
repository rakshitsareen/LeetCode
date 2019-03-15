package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {

	public List<String> removeInvalidParenthesesBFS(String s) {
		List<String> output = new ArrayList<>();
		if (null == s)
			return output;
		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		q.add(s);
		visited.add(s);
		boolean found = false;
		while (!q.isEmpty()) {
			String parens = q.poll();
			if (isValid(parens)) {
				output.add(parens);
				found = true;
			}
			if (found)
				continue;
			// generate all possibilities
			for (int i = 0; i < parens.length(); i++) {
				if (parens.charAt(i) == '(' || parens.charAt(i) == ')') {
					String temp = parens.substring(0, i).concat(parens.substring(i + 1));
					if (!visited.contains(temp)) {
						q.add(temp);
						visited.add(temp);
					}
				}
			}
		}
		if (output.size() == 0)
			output.add("");
		return output;
	}

	public boolean isValid(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == '(')
				count++;
			if (c == ')' && count-- == 0)
				return false;
		}
		return count == 0;
	}

	public List<String> removeInvalidParentheses(String s) {
		Set<String> ans = new HashSet<>();
		remove(s, ans, 0, 0, new char[] { '(', ')' });
		List<String> output = new ArrayList<>(ans);
		return output;
	}

	public void remove(String s, Set<String> ans, int li, int lj, char[] bracket) {
		for (int stack = 0, i = li; i < s.length(); i++) {
			if (s.charAt(i) == bracket[0])
				stack++;
			if (s.charAt(i) == bracket[1])
				stack--;
			if (stack >= 0)
				continue;
			for (int j = lj; j <= i; j++)
				if (s.charAt(j) == bracket[1] && (j == lj || s.charAt(j - 1) != bracket[1]))
					remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, li, lj, bracket);
			return;
		}
		String reversed = new StringBuilder(s).reverse().toString();
		if (bracket[0] == '(')
			remove(reversed, ans, 0, 0, new char[] { ')', '(' });
		else
			ans.add(reversed);
	}

	public static void main(String[] args) {
		System.out.println(new RemoveInvalidParentheses().removeInvalidParenthesesBFS("(((k()(("));
	}

}
