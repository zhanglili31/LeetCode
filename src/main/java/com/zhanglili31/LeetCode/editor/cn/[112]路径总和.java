package com.zhanglili31.LeetCode.editor.cn;
import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;
//112路径总和
//2021-03-21 23:24:46
class PathSum{
    public static void main(String []args){
        Solution solution=new PathSum().new Solution();
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        targetSum-=root.val;
        if(root.left==null&&root.right==null&&targetSum==0)return true;
        return hasPathSum(root.left,targetSum)||hasPathSum(root.right,targetSum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
