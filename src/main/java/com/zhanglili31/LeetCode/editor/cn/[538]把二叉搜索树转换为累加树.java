package com.zhanglili31.LeetCode.editor.cn;

import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

//538把二叉搜索树转换为累加树
//2021-03-08 01:06:56
class ConvertBstToGreaterTree{
    public static void main(String[] args){
        Solution solution=new ConvertBstToGreaterTree().new Solution();
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
    public TreeNode convertBST(TreeNode root) {
        TreeNode node=new TreeNode(0);
        recure(root, node);
        return root;
    }

    //倒序访问二叉搜索树，
    private TreeNode recure(TreeNode cur, TreeNode sum) {
        if(cur==null)return null;
        recure(cur.right,sum);
        sum.val+=cur.val;
        cur.val=sum.val;
        System.out.println(cur.val);
        recure(cur.left,sum);
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}