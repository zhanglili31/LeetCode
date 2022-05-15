package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//510 二叉搜索树中的中序后继 II
//2022-05-16 00:49:32
class InorderSuccessorInBstIi {

    public static void main(String[] args) {
//        Solution solution = new InorderSuccessorInBstIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

//    class Solution {
//        int target = 0;
//
//        public Node inorderSuccessor(Node node) {
//            if (node == null) {
//                return null;
//            }
//            this.target = node.val;
//            if (node.right != null)
//                return findMin(node.right);
//            return findPaMin(node.parent);
//        }
//
//        public Node findPaMin(Node node) {
//            if (node == null)
//                return null;
//            if (node.val > target) {
//                return node;
//            }
//            return findPaMin(node.parent);
//        }
//
//        public Node findMin(Node node) {
//            if (node == null)
//                return null;
//            if(node.left==null)return node;
//            return findMin(node.left);
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}