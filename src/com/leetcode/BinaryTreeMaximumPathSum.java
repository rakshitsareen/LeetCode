package com.leetcode;

public class BinaryTreeMaximumPathSum {

	int maxValue;

	public int maxPathSum(TreeNode root) {
		maxValue = Integer.MIN_VALUE;
		maxPathSumUtil(root);
		return maxValue;
	}

	public int maxPathSumUtil(TreeNode root) {
		if (root == null)
			return 0;
		int maxFromLeft = maxPathSumUtil(root.left);
		int maxFromRight = maxPathSumUtil(root.right);
		int maxTillNow = Math.max(root.val, Math.max(maxFromLeft + root.val, maxFromRight + root.val));
		int temp = Math.max(maxTillNow, root.val + maxFromLeft + maxFromRight);
		maxValue = Math.max(maxValue, temp);
		return maxTillNow;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(-1);
		System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
	}

}
