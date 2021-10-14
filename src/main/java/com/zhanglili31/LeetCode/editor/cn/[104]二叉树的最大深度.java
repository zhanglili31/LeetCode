package com.zhanglili31.LeetCode.editor.cn;

import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

//104二叉树的最大深度
//2021-10-14 23:29:55
class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        TreeNode r = CreateTree.deserialize("[5,4,2,3,3,7]");
        int[] temp = {4, 5, 6, 7, 0, 1, 2};
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
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                return Math.max(maxDepth(root.left),
                                maxDepth(root.right)) + 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
