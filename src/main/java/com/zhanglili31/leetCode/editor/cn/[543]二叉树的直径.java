package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//543 二叉树的直径
//2022-03-12 19:56:05
class DiameterOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,8,4,9,5,1,2,5,4,1,5,6,2,14]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.diameterOfBinaryTree(root));
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
        int maxLength = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            recursion(root);
            return maxLength;
        }

        public int recursion(TreeNode node) {
            if (node == null)
                return -1;
            int left = recursion(node.left)+1;
            int right = recursion(node.right)+1;
            if (left + right > maxLength) {
                maxLength = left + right;
                System.out.println(maxLength);
            }
            return Math.max(left, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}