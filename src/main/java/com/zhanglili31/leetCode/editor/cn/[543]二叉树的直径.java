package com.zhanglili31.leetCode.editor.cn;//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// 👍 942 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

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
//todo 调试通过
class Solution0 {
    int maxLength=0;
    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        if(root==null)
            return 0;
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return maxLength;
    }
    public int recursion(TreeNode node) {
        if(node==null)return -1;
        int left = recursion(node.left);
        int right = recursion(node.right);
        if(left+right>maxLength){
            maxLength = left + right;
            System.out.println(maxLength);
        }
        return Math.max(left, right) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
