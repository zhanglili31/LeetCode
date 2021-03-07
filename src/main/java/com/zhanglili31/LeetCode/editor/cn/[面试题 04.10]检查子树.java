package com.zhanglili31.LeetCode.editor.cn;

import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

//面试题 04.10检查子树
//2021-03-08 00:44:27
class CheckSubtreeLcci{
    public static void main(String[] args){
        Solution solution=new CheckSubtreeLcci().new Solution();
      //System.out.println(solution);
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean checkSubTree(TreeNode s, TreeNode t) {
        return isEqual(s, t)||(s!=null)&&(checkSubTree(s.left, t)||checkSubTree(s.right, t));
    }
    private boolean isEqual(TreeNode s, TreeNode t) {
        if(s==t&&t==null)return true;
        if(s==null||t==null)return false;
        return (s.val==t.val)&&isEqual(s.left,t.left)&&isEqual(s.right,t.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}