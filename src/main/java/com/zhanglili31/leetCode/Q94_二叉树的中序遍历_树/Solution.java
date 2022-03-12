package com.zhanglili31.leetCode.Q94_二叉树的中序遍历_树;

import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        digui(root, list);
        return list;

    }

    public void digui(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        digui(root.left, list);
        list.add(root.val);
        digui(root.right, list);

    }
}
