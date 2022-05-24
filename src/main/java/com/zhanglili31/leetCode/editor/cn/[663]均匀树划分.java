package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//663 均匀树划分
//2022-05-24 12:37:55
class EqualTreePartition {

    public static void main(String[] args) {
        Solution solution = new EqualTreePartition().new Solution();
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
    class Solution {
        boolean ans = false;
        Set<Integer> hashSet = new HashSet<>();
        TreeNode root=null;


        public boolean checkEqualTree(TreeNode root) {
            this.root=root;
            int sum = recursion(root);
            if (sum % 2 != 0) {
                return false;
            }
            return hashSet.contains(sum / 2);

        }

        public int recursion(TreeNode root) {
            if (root == null || ans) {
                return 0;
            }
            int left = recursion(root.left);
            int right = recursion(root.right);
            int sum=left + root.val + right;
            if (root != this.root) {
                hashSet.add(sum);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}