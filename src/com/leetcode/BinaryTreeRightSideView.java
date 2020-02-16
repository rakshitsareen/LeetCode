package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> output = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		if(root == null) return output;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; ++i) {
				TreeNode curr = q.poll();
				if(i == 0) output.add(curr.val);
				if(curr.right != null) q.offer(curr.right);
				if(curr.left != null) q.offer(curr.left);
			}
		}
		return output;
	}
	
	public List<Integer> rightSideViewRecur(TreeNode root) {
		List<Integer> output = new ArrayList<Integer>();
		util(root, output, 0);
		return output;
		
	}
	
	private void util(TreeNode n, List<Integer> res, int d) {
		if(n == null) return;
		if(d == res.size()) res.add(n.val);
		util(n.right, res, d + 1);
		util(n.left, res, d+ 1);
	}

}
