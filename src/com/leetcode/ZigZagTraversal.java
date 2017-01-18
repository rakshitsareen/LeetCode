package com.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversal {


	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		if (root == null) {
			List<List<Integer>> list = new LinkedList<>();
			return list;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> list = new LinkedList<>();
		queue.add(root);
		queue.add(null); // marks the start of a new level
		Stack<TreeNode> leftStack = new Stack<>(), rightStack = new Stack<>();
		leftStack.push(root);
		List<Integer> levelList = new LinkedList<>();
		while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
			while (!leftStack.isEmpty()) {
				TreeNode el = leftStack.pop();
				if(el != null) levelList.add(el.val);
				if(el.left != null) rightStack.push(el.left);
				if(el.right != null) rightStack.push(el.right);
			}
			if(levelList!= null && levelList.size() > 0) list.add(levelList);
			levelList = new LinkedList<>();
			while (!rightStack.isEmpty()) {
				TreeNode el = rightStack.pop();
				if(el != null) levelList.add(el.val);
				if(el.right != null) leftStack.push(el.right);
				if(el.left != null) leftStack.push(el.left);
			}
			if(levelList!= null && levelList.size() > 0) list.add(levelList);
			levelList = new LinkedList<>();
		}
		return list;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		ZigZagTraversal traversal = new ZigZagTraversal();
		System.out.println(traversal.zigzagLevelOrder(root));
	}
}
