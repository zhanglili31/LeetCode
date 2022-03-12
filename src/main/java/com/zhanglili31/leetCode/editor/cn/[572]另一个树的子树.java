package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//572另一个树的子树
//2021-03-07 23:45:38
class SubtreeOfAnotherTree{
    public static void main(String[] args){
        Solution solution=new SubtreeOfAnotherTree().new Solution();
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isEqual(s, t)||(s!=null)&&(isSubtree(s.left, t)||isSubtree(s.right, t));
    }
    private boolean isEqual(TreeNode s, TreeNode t) {
        if(s==t&&t==null)return true;
        if(s==null||t==null)return false;
        return (s.val==t.val)&&isEqual(s.left,t.left)&&isEqual(s.right,t.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}