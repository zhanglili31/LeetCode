package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//549 二叉树中最长的连续序列
//2022-05-18 17:39:56
class BinaryTreeLongestConsecutiveSequenceIi {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeLongestConsecutiveSequenceIi().new Solution();
        TreeNode root = CreateTree.deserialize("[2,null,3,4,null,1]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.longestConsecutive(root));
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
        //树形DP
        int LEFT_INCREASE = 0;//从当前节点向左下递增
        int LEFT_DECREASE = 1;//从当前节点向左下递减
        int RIGHT_INCREASE = 2;//从当前节点向右下递增
        int RIGHT_DECREASE = 3;//从当前节点向右下递减
        int CUR_LENGTH = 4;//当前节点的最长路径
        int[] init = new int[]{1, 1, 1, 1, 1};
        Map<TreeNode, int[]> dp = new HashMap<>();
        int ans = Integer.MIN_VALUE;

        public int longestConsecutive(TreeNode root) {
            backRootTraversal(root);
            return ans;
        }

        //后跟遍历树
        public void backRootTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            backRootTraversal(root.left);
            backRootTraversal(root.right);
            int cur[] = Arrays.copyOf(init, init.length);
            if (root.left != null) {
                int[] left = dp.get(root.left);
                int leftDel = root.val - root.left.val;
                if (leftDel == 1) {
                    cur[LEFT_DECREASE] += Math.max(left[LEFT_DECREASE], left[RIGHT_DECREASE]);
                } else if (leftDel == -1) {
                    cur[LEFT_INCREASE] += Math.max(left[LEFT_INCREASE], left[RIGHT_INCREASE]);
                }
            }
            if (root.right != null) {
                int[] right = dp.get(root.right);
                int rightDel = root.val - root.right.val;
                if (rightDel == 1) {
                    cur[RIGHT_DECREASE] += Math.max(right[RIGHT_DECREASE], right[LEFT_DECREASE]);
                } else if (rightDel == -1) {
                    cur[RIGHT_INCREASE] += Math.max(right[RIGHT_INCREASE], right[LEFT_INCREASE]);
                }
            }
            cur[CUR_LENGTH] = Math.max(cur[LEFT_INCREASE] + cur[RIGHT_DECREASE], cur[LEFT_DECREASE] + cur[RIGHT_INCREASE]) - 1;
            dp.put(root, cur);
            ans = Math.max(cur[CUR_LENGTH], ans);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}