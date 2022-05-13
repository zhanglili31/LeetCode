package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//366 寻找二叉树的叶子节点
//2022-05-13 16:15:09
class FindLeavesOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new FindLeavesOfBinaryTree().new Solution();
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)return null;
        boolean flag=true;
        while(flag){
            List<Integer> temp = new ArrayList<>();
            flag=!getLeaves(root, temp);
            res.add(temp);
        }
        return res;

    }

    public boolean getLeaves(TreeNode node, List<Integer> list) {
        if (node != null&&node.left==null&&node.right==null) {
            list.add(node.val);
            return true;
        }
        boolean left=node.left!=null?getLeaves(node.left, list):false;
        boolean right=node.right!=null?getLeaves(node.right, list):false;
        if (left) {
            node.left=null;
        }
        if (right) {
            node.right=null;
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}