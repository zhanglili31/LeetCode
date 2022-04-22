package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//101 对称二叉树
//2022-04-21 14:02:45
class SymmetricTree {

    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        int temp[] = {-1,0,1,2,-1,-4};
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return false;
        return twoTreeCompare(root.left, root.right);
    }
    public boolean twoTreeCompare(TreeNode left, TreeNode right) {
        if(right==null&&left==null)return true;
        if(right==null||left==null)return false;
        if(left.val!=right.val)return false;
        return twoTreeCompare(left.left, right.right) && twoTreeCompare(left.right, right.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}