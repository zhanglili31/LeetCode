package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//236 二叉树的最近公共祖先
//2022-04-23 01:31:14
class LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
        TreeNode root = CreateTree.deserialize("[3,5,1]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.right));
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
    class Solution {
        TreeNode res = null;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            recursion2(root, p, q);
            return res;

        }

        public TreeNode recursion(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return null;
            TreeNode left = recursion(root.left, p, q);
            TreeNode right = recursion(root.right, p, q);
            if (
                    (left != null && right != null)
                            || ((left == p || left == q) && (root == p || root == q))
                            || ((right == p || right == q) && (root == p || root == q))
            ) {
                res = root;
                return res;
            }
            if (left == p || left == q)
                return left;
            if (right == p || right == q)
                return right;
            if (root == p || root == q)
                return root;
            return null;
        }

        private TreeNode recursion2(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            TreeNode node = null;
            TreeNode left = recursion2(root.left, p, q);
            TreeNode right = recursion2(root.right, p, q);
            List<TreeNode> list = new ArrayList<>();
            if (left != null) {
                list.add(left);
            }
            if (right != null) {
                list.add(right);
            }
            if (root == p || root == q) {
                list.add(root);
            }
            if (list.size() >= 2) {
                res = root;
                return null;
            } else {
                return list.size() == 0 ? null : list.get(0);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}