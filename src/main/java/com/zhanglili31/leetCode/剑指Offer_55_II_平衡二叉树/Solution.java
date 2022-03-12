package com.zhanglili31.leetCode.剑指Offer_55_II_平衡二叉树;


import java.util.TreeMap;

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
    public boolean isBalanced(TreeNode root) {
        TreeMap a = new TreeMap();
        if(root==null){
            return true;
        }
        else if(Math.abs(countH(root.left)-countH(root.right))>1){
            return false;
        }else{
            return isBalanced(root.right) && isBalanced(root.left);
        }

    }

    public int countH(TreeNode root) {
        if (root == null) {
            return 0;
        }
       return  1+Math.max(countH(root.left), countH(root.right));
    }
}
