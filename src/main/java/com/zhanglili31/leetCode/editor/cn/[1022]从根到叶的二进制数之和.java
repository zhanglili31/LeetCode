package com.zhanglili31.leetCode.editor.cn;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
//1022从根到叶的二进制数之和
//2021-03-23 09:06:44
class SumOfRootToLeafBinaryNumbers{
    public static void main(String []args){
        Solution solution=new SumOfRootToLeafBinaryNumbers().new Solution();
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
    int res=0;
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        recure(root, 0);
        return sum;
    }

    private void recure(TreeNode root, int temp) {
        if(root==null)return;
        temp+=root.val;
        if(root.left==null&&root.right==null){
            sum+=temp;
        }
        temp=temp<<1;
        recure(root.left, temp);
        recure(root.right, temp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
