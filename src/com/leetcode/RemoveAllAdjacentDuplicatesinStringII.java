package com.leetcode;

import java.util.Stack;

class C {
	char c;
	int freq;

	public C(char c, int f) {
		this.c = c;
		this.freq = f;
	}
}

public class RemoveAllAdjacentDuplicatesinStringII {

	public static String removeDuplicates(String s, int k) {
		if (s == null || k == 0 || s.length() < k)
			return s;
		Stack<C> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek().c == c)
				stack.push(new C(c, stack.peek().freq + 1));
			else
				stack.push(new C(c, 1));

			if (stack.peek().freq == k) {
				int temp = k;
				while (temp-- > 0)
					stack.pop();
			}
		}
		while (!stack.isEmpty())
			sb.append(stack.pop().c);
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abccbd", 2));
	}

	// something to try some day :: below :: couldn/t make this solution work.

//	if (s == null || s.length() <= 1 || k == 0)
//		return s;
//	int savek = k;
//	Stack<Character> stack = new Stack<Character>();
//	stack.push(s.charAt(0));
//	StringBuffer sb = new StringBuffer();
//	int i = 1;
//	while (i < s.length()) {
//		while (i < s.length() && stack.peek() == s.charAt(i) && k > 1) {
//			stack.push(s.charAt(i));
//			++i;
//			k--;
//		}
//		if (k == 1) {
//			while (k <= savek) {
//				stack.pop();
//				k++;
//			}
//		}
//		k = savek;
//		stack.push(s.charAt(i));
//		if (i == s.length() - 1)
//			break;
//		if (stack.peek() == s.charAt(i))
//			--i;
//	}
//	while (!stack.isEmpty()) {
//		sb.append(stack.pop());
//	}
//	return sb.reverse().toString();

}
