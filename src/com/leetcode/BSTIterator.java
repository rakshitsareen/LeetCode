package com.leetcode;

import java.util.Stack;

public class BSTIterator {

	Stack<TreeNode> stack;
	TreeNode root;

	public BSTIterator(TreeNode root) {
		this.root = root;
		stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null) {
			stack.push(cur);
			if (cur.left != null)
				cur = cur.left;
			else
				break;
		}
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		TreeNode cur = node;
		if(cur.right != null) {
			cur = cur.right;
			while(cur != null) {
				stack.push(cur);
				if(cur.left != null) cur = cur.left;
				else break;
			}
		}
		return node.val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

}
