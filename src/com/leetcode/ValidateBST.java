package com.leetcode;

//[2 14 74 83 64 7]

public class ValidateBST {

	private static boolean isValidBSTUtil(TreeNode root, long max, long min) {
		if (root == null)
			return true;
		if (root.val > min && root.val < max) {
			return true && isValidBSTUtil(root.left, root.val, min) && isValidBSTUtil(root.right, max, root.val);
		}
		return false;
	}

	public static boolean isValidBST(TreeNode root) {
		return isValidBSTUtil(root, Long.MAX_VALUE,Long.MIN_VALUE);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(6);
		root.left.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(7);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(3);

		System.out.println(isValidBST(root));
	}
}
