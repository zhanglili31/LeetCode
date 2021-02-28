package com.zhanglili31.LeetCode.剑指Offer_55_I_二叉树的深度;


//Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}