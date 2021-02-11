package com.zhanglili31.LeetCode.Q102_二叉树的层序遍历_树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
//一维数组保存数据
class Solution {
    public List<Integer> levelOrderl(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode tmp = null;
        while (queue.size() > 0) {
            tmp = queue.poll();
            if (tmp != null) {
                list.add(tmp.val);
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
        }
        return list;
    }
}