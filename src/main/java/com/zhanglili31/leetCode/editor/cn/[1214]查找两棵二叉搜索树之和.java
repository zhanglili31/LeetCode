package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1214 查找两棵二叉搜索树之和
//2022-06-11 15:12:18
class TwoSumBsts {

    public static void main(String[] args) {
        Solution solution = new TwoSumBsts().new Solution();
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
        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            if (root1 == null) {
                return false;
            }
            int o = target - root1.val;
            if (containsTarget(root2, o)) {
                return true;
            } else {
                return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
            }
        }

        private boolean containsTarget(TreeNode root2, int target) {
            if (root2 == null) {
                return false;
            }
            if (root2.val == target) {
                return true;
            }
            if (root2.val > target) {
                return containsTarget(root2.left, target);
            } else {
                return containsTarget(root2.right, target);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}