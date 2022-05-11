package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import java.util.Arrays;
//298 二叉树最长连续序列
//2022-05-11 10:10:57
class BinaryTreeLongestConsecutiveSequence {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeLongestConsecutiveSequence().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
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
    public int longestConsecutive(TreeNode root) {
        recursion(root, 1);
        return res;

    }
    public void recursion(TreeNode root,int len) {
        res = Math.max(res, len);
        if(root==null)return ;
        if (root.left != null && root.left.val - root.val == 1) {
            recursion(root.left, len + 1);
        }else{
            recursion(root.left, 1);
        }
        if (root.right != null && root.right.val - root.val == 1) {
            recursion(root.right, len + 1);
        }else{
            recursion(root.right, 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}