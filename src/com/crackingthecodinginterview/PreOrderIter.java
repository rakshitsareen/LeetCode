package com.crackingthecodinginterview;

import java.util.Stack;

public class PreOrderIter {

	public static void preorder(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		TreeNode temp = null;
		while (!s.isEmpty()) {
			temp = s.pop();
			System.out.print(temp.value + " ");
			if (temp.right != null)
				s.push(temp.right);
			if (temp.left != null)
				s.push(temp.left);
		}
	}

	public static void preorderRec(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.value + " ");
		preorderRec(root.left);
		preorderRec(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = null;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		preorder(root);
		System.out.println();
		preorderRec(root);
	}

}
