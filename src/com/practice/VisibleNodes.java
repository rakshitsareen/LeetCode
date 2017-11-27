package com.practice;

import com.leetcode.TreeNode;

public class VisibleNodes {

	public static int noOfVisibleNodesUtil(TreeNode root, int maxTillNow) {
		if (root == null)
			return 0;
		int valueToForward = root.val >= maxTillNow ? root.val : maxTillNow;
		int left = noOfVisibleNodesUtil(root.left, valueToForward);
		int right = noOfVisibleNodesUtil(root.right, valueToForward);
		if (root.val >= maxTillNow)
			return left + right + 1;
		else
			return left + right;
	}

	public static int noOfVisibleNodes(TreeNode root) {
		if (root == null)
			return 0;
		return noOfVisibleNodesUtil(root, Integer.MIN_VALUE);
	}

	public static void main(String[] args) {
/*		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(7);
		System.out.println(noOfVisibleNodes(root));*/
		
/*		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(21);
		root.right.left = new TreeNode(1);
		System.out.println(noOfVisibleNodes(root));*/
	}

}
