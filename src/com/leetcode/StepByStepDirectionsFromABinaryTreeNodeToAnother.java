package com.leetcode;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {

    public boolean find(TreeNode node, int n, StringBuilder sb) {
        if(node.val == n) return true;
        if(node.left != null && find(node.left, n, sb))
            sb.append("L");
        else if(node.right != null && find(node.right, n, sb))
            sb.append("R");
        return sb.length() > 0;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        if(root == null) return "";
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        find(root, startValue, a);
        find(root, destValue, b);
        int i = 0; int n = Math.min(a.length(), b.length());
        while(i < n && a.charAt(a.length() - 1 - i) == b.charAt(b.length() - 1 - i))
            i++;
        return "U".repeat(a.length() - i) + b.reverse().toString().substring(i); // reverse because we had originally built the path in reverse order.
    }
}
