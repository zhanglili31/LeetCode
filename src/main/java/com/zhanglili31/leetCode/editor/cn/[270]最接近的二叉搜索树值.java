package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//270 最接近的二叉搜索树值
//2022-05-07 09:20:52
class ClosestBinarySearchTreeValue {

    public static void main(String[] args) {
        Solution solution = new ClosestBinarySearchTreeValue().new Solution();
        TreeNode root = CreateTree.deserialize("[4,2,5]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.closestValue(root, 5.714286));
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
        int res = -1;
        double target = 0.0;
        double d = Double.MAX_VALUE;

        public int closestValue(TreeNode root, double target) {
            this.target = target;
            recursion(root);
            return res;
        }

        public void recursion(TreeNode root) {
            if (root == null)
                return;
            double d0 = Math.abs(((double) root.val) - target);
            if (Math.abs(d0) < d) {
                res = root.val;
                d = d0;
            }
            recursion(root.left);
            recursion(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}