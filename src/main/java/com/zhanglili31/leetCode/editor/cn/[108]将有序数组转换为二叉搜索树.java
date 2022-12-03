package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//108 将有序数组转换为二叉搜索树
//2022-12-03 23:47:03
class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {-10,-3,0,5,9};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.sortedArrayToBST(temp));
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
        public TreeNode sortedArrayToBST(int[] nums) {
             TreeNode node=recursion(nums, 0, nums.length - 1);
             return node;
        }
        private TreeNode recursion(int[] nums, int head, int tail) {
            if (head>tail) {
                return null;
            }
            if (head == tail) {
                return new TreeNode(nums[head]);
            }
            int mid = (head + tail) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = recursion(nums, head, mid - 1);
            root.right = recursion(nums, mid + 1, tail);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}