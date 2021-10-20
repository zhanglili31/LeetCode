package com.zhanglili31.LeetCode.editor.cn;
import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;
//114二叉树展开为链表
//2021-10-19 23:43:42
class FlattenBinaryTreeToLinkedList{
    public static void main(String []args){
        Solution solution=new FlattenBinaryTreeToLinkedList().new Solution();
        TreeNode r=CreateTree.deserialize("[1,2,5,3,4,null,6]");
        int []temp={4,5,6,7,0,1,2};
        solution.flatten(r);
        System.out.println();
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
    TreeNode res=null;
    TreeNode tmp=null;
    public void flatten(TreeNode root) {
        recursion(root);
        if (root != null) {
            root.right = res.right;
            root.left = null;
        }

    }

    public void recursion(TreeNode root) {
        if(root == null)return;
        if(res!=null){
            tmp.right = new TreeNode(root.val);
            tmp=tmp.right;
        }else{
            res=new TreeNode(root.val);
            tmp=res;
        }
        recursion(root.left);
        recursion(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
