package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//1609奇偶树
//2021-03-08 22:40:20
class EvenOddTree {
    public static void main(String[] args) {
        Solution solution = new EvenOddTree().new Solution();
        TreeNode root = CreateTree.deserialize("[5,4,2,3,3,7]");
        System.out.println(solution.isEvenOddTree(root));

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        public boolean isEvenOddTree(TreeNode root) {
            if (root == null) return false;
            Queue<Queue<TreeNode>> q0 = new LinkedList<>();
            Queue<TreeNode> q1 = new LinkedList<>();
            Queue<TreeNode> temp = null;
            Queue<TreeNode> t = null;
            int cur = 0;
            q1.add(root);
            q0.add(q1);
            boolean is = true;
            TreeNode node = null;
            int pre = Integer.MIN_VALUE;
            while (!q0.isEmpty()) {
                temp = q0.poll();
                t = new LinkedList<>();
                while (!temp.isEmpty()) {
                    node = temp.poll();
                    if (node != null) {
                        if (pre == Integer.MIN_VALUE) {
                            pre = node.val;
                            cur = pre;
                            if ((is && pre % 2 != 1) || (!is && pre % 2 != 0)) return false;
                        } else {
                            pre = cur;
                            cur = node.val;
                            if ((is && (cur % 2 != 1 || pre >= cur)) || (!is && (cur % 2 != 0 || pre <= cur)))
                                return false;
                        }
                        t.add(node.left);
                        t.add(node.right);
                    }
                }
                is = !is;
                if (t.size() > 0) q0.add(t);
                pre = Integer.MIN_VALUE;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}