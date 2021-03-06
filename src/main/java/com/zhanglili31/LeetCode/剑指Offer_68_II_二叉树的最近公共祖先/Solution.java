package com.zhanglili31.LeetCode.剑指Offer_68_II_二叉树的最近公共祖先;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) {
            return root;
        }
        TreeNode P = lowestCommonAncestor(root.left, p, q);
        TreeNode Q = lowestCommonAncestor(root.right, p, q);
        if ((P == p || P == q) && (Q == p || Q == q)) return root;
        return P!=null?P:Q;
    }
}