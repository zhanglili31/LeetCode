package com.zhanglili31.LeetCode.editor.cn;

import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

//617合并二叉树
//2021-03-09 23:57:14
class MergeTwoBinaryTrees{
    public static void main(String[] args){
        Solution solution=new MergeTwoBinaryTrees().new Solution();
      //System.out.println(solution);

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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null) return null;
        if(root1==null){
            root1=root2;
            return root1;
        }
        if(root2==null)return root1;
        root1.val+=root2.val;
        if(root1.left==null){
            root1.left=root2.left;
        }
        else mergeTrees(root1.left, root2.left);
        if(root1.right==null){
            root1.right=root2.right;
        }
        else mergeTrees(root2.right, root2.right);
        return root1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

