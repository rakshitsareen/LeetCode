package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryofBinaryTree {

	List<Integer> nodes = new ArrayList<>();

	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		if (root == null)
			return nodes;
		nodes.add(root.val);
		leftboundary(root.left);
		leaves(root.left);
		leaves(root.right);
		rightboundary(root.right);
		return nodes;
	}

	private void leftboundary(TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			return;
		nodes.add(root.val);
		if (root.left == null)
			leftboundary(root.right);
		else
			leftboundary(root.left);
	}

	private void rightboundary(TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			return;
		if (root.right == null)
			rightboundary(root.left);
		else
			rightboundary(root.right);
		nodes.add(root.val);
	}

	private void leaves(TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			nodes.add(root.val);
			return;
		}
		leaves(root.left);
		leaves(root.right);
	}
}
