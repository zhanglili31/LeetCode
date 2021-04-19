package com.zhanglili31.LeetCode.editor.cn;
import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;
//110平衡二叉树
//2021-03-17 23:50:58
class BalancedBinaryTree{
    public static void main(String []args){
        Solution solution=new BalancedBinaryTree().new Solution();
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
    public boolean isBalanced(TreeNode root) {
        return getHight(root)>0;
    }
    public int getHight(TreeNode root){
        if(root==null)return 0;
        int left=getHight(root.left);
        int right=getHight(root.right);
        if(Math.abs(left-right)>1)return -Math.abs(left-right);
        else return 1 + Math.max(left, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
