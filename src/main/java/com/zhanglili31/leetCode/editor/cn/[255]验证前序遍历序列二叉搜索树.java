package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;
import java.util.LinkedList;

//255 验证前序遍历序列二叉搜索树
//2022-05-07 01:59:22
class VerifyPreorderSequenceInBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new VerifyPreorderSequenceInBinarySearchTree().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        int []temp2 = {2, 3, 1};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.verifyPreorder(temp2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //解题思路：单调递减栈
        public boolean verifyPreorder(int[] preorder) {
            LinkedList<Integer> stack = new LinkedList<>();
            int root = Integer.MIN_VALUE;
            stack.push(preorder[0]);
            for (int i = 1; i < preorder.length; i++) {
                if (preorder[i] < root)
                    return false;
                if (preorder[i] < stack.peek() && preorder[i] > root) {
                    stack.push(preorder[i]);
                } else {
                    while (stack.size() > 0 && preorder[i] > stack.peek()) {
                        root = stack.pop();
                    }
                    stack.push(preorder[i]);
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}