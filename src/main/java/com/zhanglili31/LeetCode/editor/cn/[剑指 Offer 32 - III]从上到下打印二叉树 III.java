package com.zhanglili31.LeetCode.editor.cn;

import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//剑指 Offer 32 - III从上到下打印二叉树 III
//2021-03-07 19:48:04
class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
        TreeNode root= CreateTree.deserialize("[3,9,20,null,null,15,7]");
        System.out.println(solution.levelOrder(root));

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<Queue<TreeNode>> queue = new LinkedList<>();
            Queue<TreeNode> first = new LinkedList<>();
            Queue<TreeNode> temp = null;
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            first.add(root);
            queue.add(first);
            boolean doReverse = false;
            while (!queue.isEmpty()) {
                temp = queue.poll();
                List<Integer> list = new ArrayList<>();
                Queue<TreeNode> tempQ = new LinkedList<>();
                while (!temp.isEmpty()) {
                    TreeNode node = temp.poll();
                    if (node != null) {
                        list.add(node.val);
                        tempQ.add(node.left);
                        tempQ.add(node.right);
                    }
                }
                if (list.size() > 0) {
                    if (doReverse) {
                        reverse(list);
                    }
                    doReverse = !doReverse;
                    res.add(list);
                }
                if (tempQ.size() > 0) queue.add(tempQ);
            }
            return res;
        }

        private void reverse(List list) {
            int i = 0, j = list.size() - 1;
            Object temp = null;
            while (i < j) {
                temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
                j--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}