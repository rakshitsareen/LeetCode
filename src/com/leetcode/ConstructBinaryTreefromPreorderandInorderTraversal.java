package com.leetcode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = helper(0,0,inorder.length - 1, preorder, inorder);
        return root;
    }
    
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart > preorder.length -1 || inStart > inEnd) return null;
        int pre = preorder[preStart];
        int index = 0;
        TreeNode node = new TreeNode(pre);
        for(int i = inStart; i <= inEnd; ++i){
            if(inorder[i] == node.val)
                index = i;
        }
        node.left = helper(preStart + 1, inStart, index - 1, preorder, inorder);
        node.right = helper(preStart + index + 1 - inStart, index + 1, inEnd, preorder, inorder);
        return node;
    }

}
