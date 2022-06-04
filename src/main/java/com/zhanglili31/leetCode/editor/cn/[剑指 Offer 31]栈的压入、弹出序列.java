package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.Stack;

//剑指 Offer 31 栈的压入、弹出序列
//2022-06-04 08:23:50
class ZhanDeYaRuDanChuXuLieLcof {

    public static void main(String[] args) {
        Solution solution = new ZhanDeYaRuDanChuXuLieLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {1,2,3,4,5};
        int temp2[] = {4,3,5,1,2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.validateStackSequences(temp, temp2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<Integer>();
            int push=0;
            int pop=0;
            while (push <= pushed.length) {
                if (push < pushed.length&&(stack.isEmpty() || stack.peek() != popped[pop])) {
                    stack.push(pushed[push++]);
                }else if(!stack.isEmpty()&&stack.peek()==popped[pop]){
                    stack.pop();
                    pop++;
                }else{
                    return pop==popped.length;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}