package com.leetcode;


import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorofBinaryTreeIII {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> seen = new HashSet<>();
        while(p != null){
            seen.add(p);
            p = p.parent;
        }
        while(q!= null){
            if(seen.contains(q)) return q;
            q = q.parent;
        }
        return null;
    }

    public Node lowestCommonAncestor2(Node p, Node q) {
        Node a = p;
        Node b = q;
        while(a != b){
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }
        return a;
    }
}
