package com.leetcode;

import java.util.Stack;

public class ValidateStackSequences {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> push = new Stack<>();
		int index = 0;
		for (int i = 0; i < pushed.length; ++i) {
			push.push(pushed[i]);
			while (!push.isEmpty() && (push.peek() == popped[index])) {
				push.pop();
				index++;
			}
		}
		return push.isEmpty();
	}
}
