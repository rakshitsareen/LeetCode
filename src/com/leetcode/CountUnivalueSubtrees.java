package com.leetcode;

public class CountUnivalueSubtrees {

	private int result;

	public int countUnivalSubtrees(TreeNode root) {
		if (root == null)
			return 0;
		helper(root);
		return result;
	}

	private boolean helper(TreeNode root) {
		if (root == null)
			return true;
		boolean left = helper(root.left);
		boolean right = helper(root.right);
		if (left && right && (root.left == null || root.left.val == root.val)
				&& (root.right == null || root.right.val == root.val)) {
			result++;
			return true;
		}
		return false;

	}

}
