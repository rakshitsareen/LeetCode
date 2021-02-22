package com.leetcode;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    Node head;

    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        Node left = treeToDoublyList(root.left);
        Node right = treeToDoublyList(root.right);
        root.left = root;
        root.right = root;
        return connect(connect(left, root), right);
    }

    private Node connect(Node n1, Node n2) {
        if(n1 == null) return n2;
        if(n2 == null) return n1;
        Node tail1 = n1.left;
        Node tail2 = n2.left;
        tail1.right = n2;
        n2.left = tail1;
        tail2.right = n1;
        n1.left = tail2;

        return n1;
    }
}
