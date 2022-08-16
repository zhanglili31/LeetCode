package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1302 层数最深叶子节点的和
//2022-08-17 00:59:40
class DeepestLeavesSum {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new DeepestLeavesSum().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
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
    //解题思路：

    /**
     * 递归遍历树的结构，判断叶节点
     * 实时记录叶节点的层数
     * 如果当前叶姐点层数和最大叶节点层数相同，那么累加，
     * 如果当前叶节点层数大于最大叶节点层数，那么重置levels，sum=root.val
     */
    class Solution {
        int levels = -1;
        int sum = 0;

        public int deepestLeavesSum(TreeNode root) {
            recursion(root, 0);
            return sum;

        }

        public void recursion(TreeNode root, int l) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                if (l > levels) {
                    sum = root.val;
                    levels = l;
                } else if (l == levels) {
                    sum += root.val;
                }
                return;
            }
            recursion(root.left, l + 1);
            recursion(root.right, l + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}