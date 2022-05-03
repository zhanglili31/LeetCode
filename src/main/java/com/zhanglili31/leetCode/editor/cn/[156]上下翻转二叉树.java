package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import java.util.Arrays;
//156 上下翻转二叉树
//2022-05-04 04:51:08
class BinaryTreeUpsideDown {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeUpsideDown().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        Object res = solution.upsideDownBinaryTree(root);
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
    TreeNode res=null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        recursion(root);
        return res;

    }
    public TreeNode recursion(TreeNode root) {
        if(root==null||root.left==null){
            res=root;
            return root;
        }
        TreeNode left=recursion(root.left);
        left.right=root;
        left.left=root.right;
        root.left=null;
        root.right=null;
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}