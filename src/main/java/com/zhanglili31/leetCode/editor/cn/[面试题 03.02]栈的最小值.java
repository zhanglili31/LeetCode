package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.Stack;

//面试题 03.02 栈的最小值
//2022-06-16 17:57:44
class MinStackLcci {

    public static void main(String[] args) {
//        Solution solution = new MinStackLcci().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //辅助栈
    class MinStack {

        /**
         * initialize your data structure here.
         */
        Stack<Integer> stack = null;
        Stack<Integer> subStack = null;

        public MinStack() {
            stack = new Stack<>();
            subStack = new Stack<>();

        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(x);
                subStack.push(x);
            } else {
                if (x < subStack.peek()) {
                    subStack.push(x);
                } else {
                    subStack.push(subStack.peek());
                }
                stack.push(x);
            }

        }

        public void pop() {
            stack.pop();
            subStack.pop();

        }

        public int top() {
            return stack.peek();

        }

        public int getMin() {
            return subStack.peek();

        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}