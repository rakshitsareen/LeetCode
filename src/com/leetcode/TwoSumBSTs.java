package com.leetcode;

import java.util.Stack;

public class TwoSumBSTs {
	public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		TreeNode t1, t2;
		while (true) {
			while (root1 != null) {
				s1.push(root1);
				root1 = root1.left;
			}

			while (root2 != null) {
				s2.push(root2);
				root2 = root2.right;
			}

			if (s1.isEmpty() || s2.isEmpty())
				break;

			t1 = s1.peek();
			t2 = s2.peek();

			if (t1.val + t2.val == target) {
				return true;
			}

			else if (t1.val + t2.val < target) {
				s1.pop();
				root1 = t1.right;
			}

			else {
				s2.pop();
				root2 = t2.left;
			}
		}
		return false;
	}
}
