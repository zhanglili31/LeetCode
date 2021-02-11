package com.zhanglili31.LeetCode.Q102_二叉树的层序遍历_二维数组;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Queue> lq = new ArrayList<Queue>();
        Queue<Queue> qq = new LinkedList<Queue>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> tmpqq=null;
        queue.add(root);
        qq.add(queue);
        TreeNode tmp = null;
        while (qq.size() > 0) {
            tmpqq=qq.poll();
            List<Integer> l = new ArrayList<Integer>();
            Queue<TreeNode> qNode = new LinkedList<TreeNode>();
            while(tmpqq.size()>0){
                tmp = tmpqq.poll();
                if (tmp != null) {
                    l.add(tmp.val);
                    qNode.add(tmp.left);
                    qNode.add(tmp.right);
                }
            }
            if(l.size()>0)list.add(l);
            if(qNode.size()>0) qq.add(qNode);

        }
        return list;
    }
}