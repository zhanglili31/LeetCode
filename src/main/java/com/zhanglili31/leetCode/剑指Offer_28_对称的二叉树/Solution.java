package com.zhanglili31.leetCode.剑指Offer_28_对称的二叉树;


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//原理：如果对称点 L.val=R.val  那么必然会有:L.left.val=R.right.val&&L.right.val=R.left.val
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recure(root.left, root.right);
    }
    private boolean recure(TreeNode L, TreeNode R) {
        if(L==null&R==null)return true;
        if(L==null||R==null||L.val!=R.val)return false;
        return recure(L.left,R.right)&&recure(L.right, R.left);
    }
}
