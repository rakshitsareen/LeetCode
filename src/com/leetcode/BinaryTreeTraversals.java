package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeTraversals {

	public static List<Integer> postorderTraversal(TreeNode root) {
		if (root == null)
			return null;
		List<Integer> list = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			while (!isLeaf(p)) {
				stack.push(p);
				p = p.left;
			}
			if (p != null)
				list.add(p.val);
			while (!stack.isEmpty() && p == stack.peek().right) {
				p = stack.pop();
				list.add(p.val);
			}
			if (stack.isEmpty())
				p = null;
			else {
				p = stack.peek().right;
			}
		}
		return list;
	}

	public static boolean isLeaf(TreeNode node) {
		if (node == null)
			return true;
		return node.left == null && node.right == null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		List<Integer> ans = postorderTraversal(root);
		for (Integer i : ans)
			System.out.print(" " + i);
		return;
	}

}
