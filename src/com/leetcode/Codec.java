
package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
	private static final String splitter = ",";
	private static final String NN = "X";

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		if (root == null)
			return null;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		StringBuilder s = new StringBuilder();
		while (!q.isEmpty()) {
			TreeNode node = q.peek();
			q.poll();
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
	public static TreeNode deserialize(String data) {
		if (data == null)
			return null;
		if (data.length() == 0)
			return null;
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode root = null;
		String[] _data = data.split(splitter);
		int left = 1, right = 2;
		String s = _data[0];
		q.add(new TreeNode(Integer.parseInt(s)));
		TreeNode save_root = q.peek();
		while (!q.isEmpty()) {
			root = q.peek();
			if (root != null) {
				q.poll();
				String leftChar = _data[left];
				String rightChar = _data[right];
				if (leftChar.equals(NN)) {
					root.left = null;
				} else {
					root.left = new TreeNode(Integer.parseInt(leftChar));
					q.add(root.left);
				}
				if (rightChar.equals(NN)) {
					root.right = null;
				} else {
					root.right = new TreeNode(Integer.parseInt(rightChar));
					q.add(root.right);
				}
				left += 2;
				right += 2;
			}
		}
		return save_root;
	}

	public static void preorder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(" " + root.val);
		preorder(root.left);
		preorder(root.right);
	}

	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.right.left = new TreeNode(4);
		head.right.right = new TreeNode(5);
		head.right.right.left = new TreeNode(6);
		preorder(head);
		String data = serialize(head);
		// System.out.println(data);
		TreeNode root = deserialize(data);
		System.out.println();
		preorder(root);
		// System.out.println(root);
	}

}
