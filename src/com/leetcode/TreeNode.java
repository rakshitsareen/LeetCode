package com.leetcode;

public class TreeNode {
	public Integer val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		this.val = x;
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