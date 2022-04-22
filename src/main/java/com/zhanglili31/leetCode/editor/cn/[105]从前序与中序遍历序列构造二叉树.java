package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//105 从前序与中序遍历序列构造二叉树
//2022-04-22 17:02:37
class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        int temp[] = {3,9,20,15,7};
        int temp2[] = {9,3,15,20,7};
        System.out.println(solution.buildTree(temp, temp2));
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=null;
        if(preorder.length==0)return null;
        root = new TreeNode(preorder[0]);
        int index = findIndex(inorder, preorder[0]);
        if(index>0)root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        if(index<inorder.length)root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }
    public int findIndex(int []a ,int key) {
        for (int i = 0; i < a.length; i++) {
            if(a[i]==key)return i;
        }
        return -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
 
}