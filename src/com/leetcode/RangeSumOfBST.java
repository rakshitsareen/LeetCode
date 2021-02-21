package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumOfBST {
    public int rangeSumBSTlevelOrder(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int output = 0;
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.val >= low && curr.val <= high)
                output += curr.val;
            if(curr.left != null) queue.offer(curr.left);
            if(curr.right != null) queue.offer(curr.right);
        }
        return output;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        if(root.val < low) return rangeSumBST(root.right, low, high);
        if(root.val > high) return rangeSumBST(root.left, low, high);
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
