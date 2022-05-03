package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//437 路径总和 III
//2022-05-03 03:05:00
class PathSumIii {

    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
        TreeNode root = CreateTree.deserialize("[-2,1,3,-1]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.pathSum(root, -1));
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
        int res = 0;

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null)
                return 0;
            recursionSum(root, targetSum);
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
            return res;

        }

        public int recursionSum(TreeNode root, int targetSum) {
            if (root == null)
                return 0;

            targetSum -= root.val;
            if (targetSum == 0) {
                res++;
            }
            recursionSum(root.left, targetSum);
            recursionSum(root.right, targetSum);
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}