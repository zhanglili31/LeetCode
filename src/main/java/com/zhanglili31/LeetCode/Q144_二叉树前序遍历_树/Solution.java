package com.zhanglili31.LeetCode.Q144_二叉树前序遍历_树;


import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        digui(root, list);
        return list;
    }
    public void digui(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        digui(root.left, list);
        digui(root.right, list);

    }
}