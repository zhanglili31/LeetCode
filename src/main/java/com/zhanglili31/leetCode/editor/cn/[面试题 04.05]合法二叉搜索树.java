package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//面试题 04.05 合法二叉搜索树
//2022-11-14 23:52:54
class LegalBinarySearchTreeLcci {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new LegalBinarySearchTreeLcci().new Solution();
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
     * TreeNode(int x) { val = x; }
     * }
     */
    //题目的关键点就是需要递归的时候返回两个值，最小值和最大值
    class Solution {
        boolean ans = true;
        final int MAX = 1;
        final int MIN = 0;

        public boolean isValidBST(TreeNode root) {
            recursion(root);
            return ans;


        }

        private int[] recursion(TreeNode root) {
            if (!ans) {
                return null;
            }
            if (root == null) {
                return null;
            }
            int[] re = new int[]{root.val, root.val};
            int[] left = recursion(root.left);
            int[] right = recursion(root.right);
            if (left != null) {
                if (left[MAX] >= root.val) {
                    ans = false;
                    return null;
                }
                re[MIN] = left[MIN];
            }
            if (right != null) {
                if (root.val >= right[MIN]) {
                    ans = false;
                    return null;
                }
                re[MAX] = right[MAX];
            }
            return re;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}