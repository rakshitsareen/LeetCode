package com.crackingthecodinginterview;

import java.util.Stack;

public class PostOrderIter {

	public static void postorder(TreeNode root) {
		TreeNode temp = null;
		if (root == null)
			return;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			temp = s1.pop();
			if (temp.left != null)
				s1.push(temp.left);
			if (temp.right != null)
				s1.push(temp.right);
			s2.push(temp);
		}
		while (!s2.isEmpty()) {
			System.out.print(s2.pop().value + " ");
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
	}

}
