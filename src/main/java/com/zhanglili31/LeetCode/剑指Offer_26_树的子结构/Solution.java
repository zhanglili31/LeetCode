package com.zhanglili31.LeetCode.剑指Offer_26_树的子结构;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A ==null||B==null) {
            return false;
        }else if(A.val==B.val&&equals(A,B)){
            return true;
        }else{
          return   isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    private boolean equals(TreeNode C, TreeNode B) {
        if (B == null) {
            return true;
        } else if (C == null) {
            return false;
        }else if(B.val==C.val){
           return  equals(C.left, B.left) && equals(C.right , B.right);
        }else return false;
    }
}