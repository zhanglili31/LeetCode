package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

//536 从字符串生成二叉树
//2022-05-18 13:20:58
class ConstructBinaryTreeFromString {

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromString().new Solution();
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
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        //对于每一个数字，当其遇到右边的第一个右括号的时候，总能在前面对应一个parent节点，
        //当每一个数字找到父节点之后，他就可以出栈。
        public TreeNode str2tree(String s) {
            if (s.length() == 0)
                return null;
//        Stack<TreeNode> stack = new Stack<>();
            LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
            char ch = ' ';
            String sign = "";
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                ch = s.charAt(i);
                if ('0' <= ch && ch <= '9') {
                    temp.append(ch);
                }
                //将积累的数字变为node节点入栈
                if ((ch == '(' || ch == ')' || i == s.length() - 1) && temp.length() > 0) {
                    temp.insert(0, sign);
                    sign = "";
                    TreeNode node = new TreeNode(Integer.valueOf(temp.toString()));
                    stack.push(node);
                    temp = new StringBuilder();

                }
                if (ch == '(') {
//                stack.add(null); do nothing
                } else if (ch == '-') {
                    sign = "-";
                } else if (ch == ')') {
                    TreeNode node = stack.pop();//弹出一个value
                    TreeNode root = stack.peek();
                    if (root.left == null) {
                        root.left = node;
                    } else {
                        root.right = node;
                    }
                }

            }
            return stack.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}