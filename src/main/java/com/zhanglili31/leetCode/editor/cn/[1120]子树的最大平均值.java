package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1120 子树的最大平均值
//2022-06-07 16:40:17
class MaximumAverageSubtree {

    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubtree().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
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
        double ans = Double.MIN_VALUE;

        public double maximumAverageSubtree(TreeNode root) {
            recursion(root);
            return ans;
        }

        public int[] recursion(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }
            int[] left = recursion(root.left);
            int[] right = recursion(root.right);
            int temp[] = new int[]{root.val + left[0] + right[0], left[1] + right[1] + 1};
            ans = Math.max(ans, ((double) temp[0]) / temp[1]);
            System.out.println(((double) temp[0]) / temp[1]);
            return temp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}