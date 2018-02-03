package com.crackingthecodinginterview;

import java.util.Stack;

public class InorderIter {

	public static void inorder(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode temp = root.left;
		s.push(root);
		while (!s.isEmpty() || temp != null) {
			while (temp != null) {
				s.push(temp);
				temp = temp.left;
			}
			temp = s.pop();
			System.out.print(temp.value + " ");
			temp = temp.right;
		}
	}

	public static void main(String[] args) {
		TreeNode root = null;
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(8);
		root.left.right.right = new TreeNode(9);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		inorder(root);
	}

}
