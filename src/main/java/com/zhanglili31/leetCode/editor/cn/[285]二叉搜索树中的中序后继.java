package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;
import java.util.TreeMap;

//285 二叉搜索树中的中序后继
//2022-05-08 17:42:41
class InorderSuccessorInBst {

    public static void main(String[] args) {
        Solution solution = new InorderSuccessorInBst().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        TreeNode res = null;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if(root==null)return null;
            if(root.val>p.val){
                TreeNode left=inorderSuccessor(root.left, p);
                return left==null?root:left;
            }if(root.val==p.val){
                return recursion(root.right);
            }else{
                return inorderSuccessor(root.right, p);
            }
        }

        //这种方式太复杂了，并且存在一些递归的问题。弃用
        public TreeNode deal(TreeNode root, TreeNode p, TreeNode root2) {
            if (root == null)
                return null;
            if (root.val > p.val) {
                if (root.left != null && root.left.val == p.val) {
                    res = recursion(root.left.right);
                    return res == null ? root : res;
                } else {
                    return deal(root.left, p, root);
                }
            } else if (root.val < p.val) {
                if (root.right != null && root.right.val == p.val) {
                    res = recursion(root.right.right);
                    return res == null ? root2 : res;
                } else {
                    return deal(root.right, p, root);
                }
            } else {
                return recursion(root.right);
            }
        }

        public TreeNode recursion(TreeNode root) {
            if (root == null)
                return null;
            TreeNode left = recursion(root.left);
            if (left != null)
                return left;
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}