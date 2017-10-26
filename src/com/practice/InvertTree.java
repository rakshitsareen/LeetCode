package com.practice;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.TreeNode;

public class InvertTree {

	TreeNode root;

	public TreeNode invertTreeIter(TreeNode root) {
		if (root == null)
			return null;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
		return root;
	}

	public TreeNode invertTreeRec(TreeNode root) {
		if (root == null)
			return null;
		invertTreeRec(root.left);
		invertTreeRec(root.right);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(" " + root.val);
		inorder(root.right);
	}

	public void postorder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(" " + root.val);
		postorder(root.left);
		postorder(root.right);
	}

	public static void main(String[] args) {
		InvertTree tree = new InvertTree();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(8);
		tree.root.right = new TreeNode(2);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(2);
		tree.postorder(tree.root);
		tree.invertTreeIter(tree.root);
		tree.invertTreeRec(tree.root);
		System.out.println("");
		tree.postorder(tree.root);
	}
}
