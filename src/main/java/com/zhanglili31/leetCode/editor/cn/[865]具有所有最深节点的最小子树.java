package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

//865具有所有最深节点的最小子树
//2021-03-22 00:57:25
class SmallestSubtreeWithAllTheDeepestNodes {
    public static void main(String[] args) {
        Solution solution = new SmallestSubtreeWithAllTheDeepestNodes().new Solution();
        TreeNode r = CreateTree.deserialize("[3,5,1,6,2,0,8,null,null,7,4]");
        System.out.println(solution.subtreeWithAllDeepest(r));
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
        TreeNode res = null;
        int h = 0;
        Set<TreeNode> set = new HashSet<>();

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            getH(root, 0);
            return findPa(root);
        }

        private void getH(TreeNode node, int height) {
            if (node == null) return;
            if (height > h) {
                res = node;
                h = height;
                set.clear();
                set.add(node);
            } else if (height == h) {
                set.add(node);
            }
            height++;
            getH(node.left, height);
            getH(node.right, height);
        }

        private TreeNode findPa(TreeNode node) {
            if (node == null||set.contains(node)) return node;
            TreeNode L = findPa(node.left);
            TreeNode R = findPa(node.right);
            if(L!=null&&R!=null)return node;
            if(L!=null)return L;
            if(R!=null)return R;
            return null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
