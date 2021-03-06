package com.zhanglili31.LeetCode.剑指Offer_32_I_从上到下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return new int[0];
        queue.add(root);
        TreeNode temp=null;
        while (!queue.isEmpty()) {
            temp=queue.poll();
            if (temp != null) {
                queue.add(temp.left);
                queue.add(temp.right);
                list.add(temp.val);
            }
        }
        int res[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}