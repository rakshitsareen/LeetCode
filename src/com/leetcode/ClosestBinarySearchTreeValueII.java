package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)->Math.abs(a - target) > Math.abs(b - target) ? -1 : 1);
        inorder(root, k, heap);
        return new ArrayList<>(heap);
    }
    private void inorder(TreeNode root, int k, PriorityQueue heap){
        if(root == null) return;
        inorder(root.left, k, heap);
        heap.add(root.val);
        if(heap.size() > k)
            heap.poll();
        inorder(root.right, k, heap);
    }
}