package com.leetcode;

public class MaximumPathSumTree {
	public static int globalMax;

	public static int maxPathSumBetweenLeavesUtil(TreeNode root, int max) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.val;
		int left = maxPathSumBetweenLeavesUtil(root.left, globalMax);
		int right = maxPathSumBetweenLeavesUtil(root.right, globalMax);
		if (root.left != null && root.right != null) {
			globalMax = Math.max(globalMax, left + right + root.val);
			return Math.max(left, right) + root.val;
		}
		return (root.left == null) ? right + root.val : left + root.val;
	}

	public static int maxPathSumBetweenLeaves(TreeNode root) {
		maxPathSumBetweenLeavesUtil(root, Integer.MIN_VALUE);
		return globalMax;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-15);
		root.left = new TreeNode(5);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(-8);
		root.left.right = new TreeNode(1);
		root.left.left.left = new TreeNode(2);
		root.left.left.right = new TreeNode(6);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(9);
		root.right.right.right = new TreeNode(0);
		root.right.right.right.left = new TreeNode(4);
		root.right.right.right.right = new TreeNode(-1);
		root.right.right.right.right.left = new TreeNode(10);
		System.out.println(maxPathSumBetweenLeaves(root));
	}

}
