package com.leetcode;

/*
 *  Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the 
 *  two trees are overlapped while the others are not.
 *  You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 *  then sum node values up as the new value of the merged node.
 *  Otherwise, the NOT null node will be used as the node of new tree. 
 */

public class MergeTwoBinaryTrees {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null) return t2;
		if(t2 == null) return t1;
		t1.val=  t1.val+ t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		if (root != null)
			System.out.println(root.val);
		inorder(root.right);
	}

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(5);
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.left.right = new TreeNode(4);
		root2.right = new TreeNode(3);
		root2.right.right = new TreeNode(7);
		MergeTwoBinaryTrees sol = new MergeTwoBinaryTrees();
		TreeNode mtree = sol.mergeTrees(root1, root2);
		sol.inorder(mtree);
	}

}
