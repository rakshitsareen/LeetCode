package com.leetcode;

public class PopulatingNextRightPointersinEachNode {

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

    public Node connect(Node root) {
		Node temp = new Node(0);
		Node save_root = root;
		while (root != null) {
			Node currchild = temp;
			while (root != null) {
				if (root.left != null) {
					currchild.next = root.left;
					currchild = currchild.next;
				}
				if (root.right != null) {
					currchild.next = root.right;
					currchild = currchild.next;
				}
				root = root.next;
			}
			root = temp.next;
			temp.next = null;
		}
		return save_root;
	}

	public Node connectRecur(Node root) {
		if (root == null)
			return root;
		if (root.left != null)
			root.left.next = root.right;
		if (root.right != null) {
			if (root.next != null)
				root.right.next = root.next.left;
		}
		connectRecur(root.left);
		connectRecur(root.right);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
