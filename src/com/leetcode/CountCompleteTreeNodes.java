package com.leetcode;

public class CountCompleteTreeNodes {

	public int countNodes(TreeNode root) {
		TreeNode left = root, right = root;
		int height = 0;
		while (right != null) {
			left = left.left;
			right = right.right;
			height++;
		}
		if (left == null) {
			return (1 << height) - 1;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

}
