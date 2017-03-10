// Source: http://www.geeksforgeeks.org/remove-invalid-parentheses/

package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RemoveMinimumBrackets {

	Queue<String> queue;
	Set<String> set;
	boolean level;

	public void removeInvalidParentheses(String str) {
		if (str == null || str.length() == 0) {
			return;
		}
		queue = new LinkedList<>();
		set = new HashSet<>();

		queue.add(str);
		set.add(str);

		while (!queue.isEmpty()) {
			str = queue.poll();
			if (str != null) {
				if (isValidString(str)) {
					System.out.println(str);
					level = true;
				}
			}
			if (level)
				continue;
			for (int i = 0; i < str.length(); i++) {
				// remove parentheses one by one and add to queue for further
				// processing.
				String temp = str.substring(0, i) + str.substring(i + 1);
				if (!set.contains(temp)) {
					queue.add(temp);
					set.add(temp);
				}
			}
		}
	}

	public boolean isValidString(String str) {
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(')
				cnt++;
			else if (str.charAt(i) == ')')
				cnt--;
			if (cnt < 0)
				return false;
		}
		return cnt == 0;
	}

	public static void main(String[] args) {
		RemoveMinimumBrackets solution = new RemoveMinimumBrackets();
		String s = "()())()";
		solution.removeInvalidParentheses(s);
		s = "()v)";
		solution.removeInvalidParentheses(s);
		return;
	}
}
