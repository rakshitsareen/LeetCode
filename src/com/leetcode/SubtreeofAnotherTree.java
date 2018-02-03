package com.leetcode;

public class SubtreeofAnotherTree {

	public static boolean checkIfEqual(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 == null)
			return false;
		if (node2 == null)
			return false;
		if (node1.val == node2.val) {
			return checkIfEqual(node1.left, node2.left) && checkIfEqual(node1.right, node2.right);
		} else {
			return false;
		}
	}

	public static boolean checkSubtree(TreeNode root, TreeNode subtree) {
		if(root == null && subtree == null) return true;
		if(root == null || subtree == null) return false;
		
		if (checkIfEqual(root, subtree))
			return true;
		return checkSubtree(root.left, subtree) || checkSubtree(root.right, subtree);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
