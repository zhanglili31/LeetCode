package com.zhanglili31.leetCode.editor.cn;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
//897递增顺序查找树
//2021-03-19 01:07:40
class IncreasingOrderSearchTree{
    public static void main(String []args){
        Solution solution=new IncreasingOrderSearchTree().new Solution();
        TreeNode r=CreateTree.deserialize("[5,3,6,2,4,null,8,1,null,null,null,7,9]");
        System.out.println(solution.increasingBST(r));
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
class Temp{
    TreeNode head;
    TreeNode tail;
}
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        Temp temp=null;
        recure(root, temp);
        return temp.head;
    }

    private void recure(TreeNode root,Temp temp) {
        if(root==null)return;
        recure(root.left,temp);
        if (temp.head==null){
            temp.head=new TreeNode(root.val);
            temp.tail= temp.head;
        }else{
            temp.tail.right=new TreeNode(root.val);
            temp.tail= temp.tail.right;
        }
        recure(root.right,temp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
