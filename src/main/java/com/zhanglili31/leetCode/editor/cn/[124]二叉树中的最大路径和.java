package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//124 二叉树中的最大路径和
//2022-04-22 18:35:51
class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        TreeNode root = CreateTree.deserialize("[-10,9,20,null,null,15,7]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.maxPathSum(root));
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
        int maxValue = Integer.MIN_VALUE;
        int maxValue2 = Integer.MIN_VALUE;

        public int recursion(TreeNode root) {
            if (root == null)
                return 0;
            int tempMaxValue = Integer.MIN_VALUE;
            int leftMaxValue = recursion(root.left);
            int rightMaxValue = recursion(root.right);
            tempMaxValue = Math.max(Math.max(leftMaxValue, rightMaxValue) + root.val,root.val);
            int rootMaxValue = Math.max(tempMaxValue, leftMaxValue + rightMaxValue + root.val);
            if (rootMaxValue > maxValue)
                maxValue = rootMaxValue;
            return tempMaxValue;
        }

        public int maxPathSum(TreeNode root) {
             recursion(root);
            return maxValue;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}