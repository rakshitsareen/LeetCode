package com.practice;

//Java program to implement iterative preorder traversal
import java.util.Stack;

import com.leetcode.TreeNode;

public class BinaryTreePreorderIter {

	TreeNode root;

	void iterativePreorder() {
		iterativePreorder(root);
	}

	// An iterative process to print preorder traversal of Binary tree
	void iterativePreorder(TreeNode node) {

		// Base Case
		if (node == null) {
			return;
		}

		// Create an empty stack and push root to it
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(root);

		/*
		 * Pop all items one by one. Do following for every popped item a) print it b)
		 * push its right child c) push its left child Note that right child is pushed
		 * first so that left is processed first
		 */
		while (nodeStack.empty() == false) {

			// Pop the top item from stack and print it
			TreeNode mynode = nodeStack.peek();
			System.out.print(mynode.val + " ");
			nodeStack.pop();

			// Push right and left children of the popped node to stack
			if (mynode.right != null) {
				nodeStack.push(mynode.right);
			}
			if (mynode.left != null) {
				nodeStack.push(mynode.left);
			}
		}
	}

	// driver program to test above functions
	public static void main(String[] args) {
		BinaryTreePreorderIter tree = new BinaryTreePreorderIter();
		tree.root = new TreeNode(10);
		tree.root.left = new TreeNode(8);
		tree.root.right = new TreeNode(2);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(2);
		tree.iterativePreorder();

	}
}
