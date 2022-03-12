package com.zhanglili31.leetCode.Q145_二叉树的后序遍历_树;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        digui(root, list);
        return list;
    }
    public void digui(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        digui(root.left, list);
        digui(root.right, list);
        list.add(root.val);

    }
}