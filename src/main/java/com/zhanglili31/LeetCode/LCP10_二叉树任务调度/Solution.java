package com.zhanglili31.LeetCode.LCP10_二叉树任务调度;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//CSDN: https://blog.csdn.net/haut_ykc/article/details/105626734
//官方的解法2:https://leetcode-cn.com/problems/er-cha-shu-ren-wu-diao-du/solution/dfs-si-lu-dai-ma-he-zheng-ming-by-leetcode-solutio/
//这个题目比较难，建议刷二遍
class Solution {
    public double minimalExecTime(TreeNode root) {
        if (root == null) return 0;
        double left = minimalExecTime(root.left);
        double right = minimalExecTime(root.right);
        return Math.max(left, Math.max(right, (getSum(root.left) + getSum(root.right)) / 2)) + root.val;
    }

    private double getSum(TreeNode node) {
        if (node == null) return 0;
        return getSum(node.left) + getSum(node.right) + node.val;
    }
}