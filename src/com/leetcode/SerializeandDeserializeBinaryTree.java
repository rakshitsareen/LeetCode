package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {
	private static String splitter = ",";
	private static String NN = "X";

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		if (root == null)
			return null;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		StringBuilder s = new StringBuilder();
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node != null) {
				q.add(node.left);
				q.add(node.right);
				s.append(node.val).append(splitter);
			} else {
				s.append(NN).append(splitter);
			}
		}
		return s.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0)
			return null;
		String[] split = data.split(splitter);
		int left = 1, right = 2;
		String s = split[0];
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(new TreeNode(Integer.parseInt(s)));
		TreeNode save_root = q.peek();
		while (!q.isEmpty()) {
			TreeNode root = q.poll();
			if (root != null) {
				String lchar = split[left];
				String rchar = split[right];
				if (lchar.equals(NN)) {
					root.left = null;
				} else {
					root.left = new TreeNode(Integer.parseInt(lchar));
					q.add(root.left);
				}
				if (NN.equals(rchar)) {
					root.right = null;
				} else {
					root.right = new TreeNode(Integer.parseInt(rchar));
					q.add(root.right);
				}
				left += 2;
				right += 2;
			}
		}
		return save_root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
