package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//250 统计同值子树
//2022-05-05 22:25:33
class CountUnivalueSubtrees {

    public static void main(String[] args) {
        Solution solution = new CountUnivalueSubtrees().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
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
        int res = 0;

        public int countUnivalSubtrees(TreeNode root) {
            recursion(root);
            return res;
        }
        public int recursion(TreeNode root) {
            if (root == null)
                return 0;
            int left = recursion(root.left);
            int right = recursion(root.right);
            if (left == 0 && right == 0) {
                res++;
                return 1;
            }
            if (left != 0 && right != 0) {
                if (left == 1 && right == 1 && root.val == root.left.val && root.val == root.right.val) {
                    res++;
                    return 1;
                } else {
                    return -1;
                }
            }
            int temp = left == 0 ? right : left;
            int val = left == 0 ? root.right.val : root.left.val;
            if (temp == 1 && root.val == val) {
                res++;
                return 1;
            } else {
                return -1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}