package com.crackingthecodinginterview;

import java.util.Stack;

public class CloneATree {

	public static TreeNode cloneTree(TreeNode root) {
		if (root == null)
			return null;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(root);
		TreeNode newRoot = new TreeNode(root.value);
		TreeNode temp = null;
		TreeNode clone = null;
		s2.push(newRoot);
		while (!s1.isEmpty()) {
			temp = s1.pop();
			clone = s2.pop();
			if (temp.left != null) {
				s1.push(temp.left);
				clone.left = new TreeNode(temp.left.value);
				s2.push(clone.left);
			}
			if (temp.right != null) {
				s1.push(temp.right);
				clone.right = new TreeNode(temp.right.value);
				s2.push(clone.right);
			}
		}
		return newRoot;
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
		TreeNode newRoot = cloneTree(root);
		preorderRec(root);
		System.out.println();
		preorderRec(newRoot);
	}

}
