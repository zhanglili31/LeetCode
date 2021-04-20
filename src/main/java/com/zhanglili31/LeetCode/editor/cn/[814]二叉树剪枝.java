package com.zhanglili31.LeetCode.editor.cn;

import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

//814二叉树剪枝
//2021-03-08 01:43:17
class BinaryTreePruning {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePruning().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        System.out.println(solution.pruneTree(root));

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

        public TreeNode pruneTree(TreeNode root) {
            if(recure(root))return null;
            return root;
        }
        public boolean recure(TreeNode cur){
            if(cur==null)return true;
            boolean l = recure(cur.left);
            boolean r = recure(cur.right);
            if(l)cur.left=null;
            if(r)cur.right=null;
            return cur.val==0&&l&&r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}