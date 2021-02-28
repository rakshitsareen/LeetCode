package com.leetcode;

import javax.swing.plaf.metal.MetalTheme;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        int val, closest = root.val;
        while(root != null){
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }
}
