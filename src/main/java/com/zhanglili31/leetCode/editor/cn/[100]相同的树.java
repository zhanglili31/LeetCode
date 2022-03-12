package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//100相同的树
//2021-03-09 23:45:49
class SameTree{
    public static void main(String[] args){
        Solution solution=new SameTree().new Solution();
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&q==null)return true;
        if(q==null||p==null)return false;
        return q.val==p.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}