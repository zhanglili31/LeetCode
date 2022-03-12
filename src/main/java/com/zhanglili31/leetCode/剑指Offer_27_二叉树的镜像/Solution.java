package com.zhanglili31.leetCode.剑指Offer_27_二叉树的镜像;


//Definition for a binary tree node.node

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)return null;
        TreeNode T=root.left;
        root.left=root.right;
        root.right=T;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
