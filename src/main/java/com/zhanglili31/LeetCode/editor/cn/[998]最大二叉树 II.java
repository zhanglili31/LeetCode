package com.zhanglili31.LeetCode.editor.cn;
import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;
//998最大二叉树 II
//2021-03-20 01:08:36
class MaximumBinaryTreeIi{
    public static void main(String []args){
        Solution solution=new MaximumBinaryTreeIi().new Solution();
        TreeNode r=CreateTree.deserialize("[5,4,2,3,3,7]");
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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || root.val < val) {
            TreeNode node = new TreeNode(val);
            node.left=root;
            return node;
        }else{
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
