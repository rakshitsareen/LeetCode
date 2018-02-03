package com.leetcode;

public class DiameterOfTree {

	public static int height(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public static int diameter(TreeNode root) {
		if (root == null)
			return 0;
		int lheight = height(root.left);
		int rheight = height(root.right);

		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);
		return Math.max(rheight + lheight + 1, Math.max(ldiameter, rdiameter));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(diameter(root));
	}

}
