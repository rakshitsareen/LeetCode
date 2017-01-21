package com.leetcode;

class TreeNode {
	Integer val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public TreeNode insertLeft(TreeNode node) {
		if (null != node) {
			this.left = node;
			return node;
		} else {
			System.out.println("Cannot insert empty node");
			return null;
		}
	}

	public TreeNode insertRight(TreeNode node) {
		if (null != node) {
			this.right = node;
			return node;
		} else {
			System.out.println("Cannot insert empty node");
			return null;
		}
	}
}