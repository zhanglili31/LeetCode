package com.zhanglili31.leetCode.剑指Offer_07_重建二叉树;

import java.util.Arrays;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public static void main(String[] args) {
        int[] a = {3, 9, 20, 15, 7};
        int[] b = {9, 3, 15, 20, 7};
        new Solution().buildTree(a, b);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return  null;
        }
        TreeNode temp=new TreeNode(preorder[0]);
        int index = indexOfKey(inorder, preorder[0]);
        int[] leftPreOrder = index>0?Arrays.copyOfRange(preorder, 1, index + 1):new int[0];
        int[] leftInOrder = index>0?Arrays.copyOfRange(inorder, 0, index):new int[0];
        temp.left = buildTree(leftPreOrder, leftInOrder);

        int[] rightPreOrder = inorder.length-index>1?Arrays.copyOfRange(preorder, index + 1, preorder.length):new int[0];
        int[] rightInOrder = inorder.length-index>1?Arrays.copyOfRange(inorder, index+1,inorder.length ):new int[0];
        temp.right = buildTree(rightPreOrder, rightInOrder);
        return temp;
    }

    private int indexOfKey(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
