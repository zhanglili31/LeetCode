package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//776 拆分二叉搜索树
//2022-05-25 23:15:45
class SplitBst {

    public static void main(String[] args) {
        Solution solution = new SplitBst().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
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

//    https://leetcode.cn/problems/split-bst/solution/c-sol-by-silverblg-46/
    class Solution {
        public TreeNode[] splitBST(TreeNode root, int target) {
            TreeNode[] ans = new TreeNode[2];
            TreeNode[] temp = null;
            if(root==null)return ans;
            if (target >= root.val) {
                ans[0] = root;
                temp = splitBST(root.right, target);
                ans[0].right = temp[0];
                ans[1] = temp[1];
            } else {
                ans[1] = root;
                temp = splitBST(root.left, target);
                ans[1].left = temp[1];
                ans[0] = temp[0];
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}