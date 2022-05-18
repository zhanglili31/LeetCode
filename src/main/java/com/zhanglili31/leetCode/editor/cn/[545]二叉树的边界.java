package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//545 二叉树的边界
//2022-05-18 17:00:29
class BoundaryOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new BoundaryOfBinaryTree().new Solution();
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
        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            if (root == null)
                return null;
            List<Integer> answer = new ArrayList<Integer>();
            answer.add(root.val);
            if (root.left != null) {
                answer.addAll(findLeft(root.left, new ArrayList<>()));
            }
            if (!(root.left == null && root.right == null)) {
                answer.addAll(findLeaves(root, new ArrayList<>()));
            }
            if (root.right != null) {
                answer.addAll(findRight(root.right, new ArrayList<>()));
            }
            return answer;

        }

        public List<Integer> findLeft(TreeNode node, List<Integer> list) {
            if (node == null || (node.left == null && node.right == null)) {
                return list;
            }
            list.add(node.val);
            if (node.left != null) {
                return findLeft(node.left, list);
            } else {
                return findLeft(node.right, list);
            }
        }

        public List<Integer> findRight(TreeNode node, List<Integer> list) {
            if (node == null || (node.left == null && node.right == null)) {
                return list;
            }

            if (node.right != null) {
                findRight(node.right, list);
            } else {
                findRight(node.left, list);
            }
            list.add(node.val);
            return list;
        }

        public List<Integer> findLeaves(TreeNode node, List<Integer> list) {
            if (node != null && node.left == null && node.right == null) {
                list.add(node.val);
                return list;
            }
            if (node == null) {
                return list;
            }
            findLeaves(node.left, list);
            findLeaves(node.right, list);
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}