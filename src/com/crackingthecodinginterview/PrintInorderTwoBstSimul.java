package com.crackingthecodinginterview;

import java.util.Stack;

public class PrintInorderTwoBstSimul {

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.println(root.value);
		inorder(root.right);
	}

	public void mergeBST(TreeNode root1, TreeNode root2) {
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		TreeNode current1 = root1;
		TreeNode current2 = root2;
		if (root1 == null) {
			inorder(root2);
			return;
		}
		if (root2 == null) {
			inorder(root1);
			return;
		}
		while (current1 != null || current2 != null || !s1.isEmpty() || !s2.isEmpty()) {
			if (current1 != null || current2 != null) {
				if (current1 != null) {
					s1.push(current1);
					current1 = current1.left;
				}
				if (current2 != null) {
					s1.push(current2);
					current2 = current2.left;
				}
			} else {
				// if one tree is finished, then print the other one
				if (s1.isEmpty()) {
					while (!s2.isEmpty()) {
						current2 = s2.pop();
						current2.left = null;
						inorder(current2);
					}
					return;
				}
				if (s2.isEmpty()) {
					while (!s1.isEmpty()) {
						current1 = s2.pop();
						current1.left = null;
						inorder(current1);
					}
				}

				// comparison
				current1 = s1.pop();
				current2 = s2.pop();
				if (current1.value > current2.value) {
					System.out.println(current2.value);
					s1.push(current1);
				} else {
					System.out.println(current1.value);
					s1.push(current2);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
