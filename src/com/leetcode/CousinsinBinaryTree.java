package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsinBinaryTree {

	public boolean isCousins(TreeNode root, int x, int y) {
		if(root == null) return false;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			boolean A = false;
			boolean B = false;
			for(int i = 0; i < size; ++i) {
				TreeNode curr = q.poll();
				if(curr.val == x) A = true;
				if(curr.val == y) B = true;
				if(curr.left != null && curr.right != null) {
					if(curr.left.val == x && curr.right.val == y) return false;	// same parent
					if(curr.left.val == y && curr.right.val == x) return false; // same parent
				}
				if(curr.left != null)
					q.offer(curr.left);
				if(curr.right != null)
					q.offer(curr.right);
			}
			if(A && B) return true;
			if(A || B) return false;
		}
		return false;
	}

}
