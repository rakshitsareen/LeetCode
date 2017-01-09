package com.leetcode;

public class MinDepthOfBinTree {
	public TreeNode root;
	public static int INTEGER = 1;

	public int findMinDepth(TreeNode root) {

		if (root == null)
			return 0;

		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null) {
			return findMinDepth(root.right) + 1;
		}

		if (root.right == null) {
			return findMinDepth(root.left) + 1;
		}

		return Math.min(findMinDepth(root.left), findMinDepth(root.right)) + 1;
	}

	public static void main(String[] args) {
		MinDepthOfBinTree tree = new MinDepthOfBinTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		System.out.println(tree.findMinDepth(tree.root));
	}
}
