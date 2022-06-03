package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.Stack;

//剑指 Offer 30 包含min函数的栈
//2022-06-03 06:24:24
class BaoHanMinhanShuDeZhanLcof {

    public static void main(String[] args) {
//        Solution solution = new BaoHanMinhanShuDeZhanLcof().new Solution();
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
    class MinStack {

        /**
         * initialize your data structure here.
         */
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> subStack = new Stack<>();

        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            if (subStack.isEmpty() || x < subStack.peek()) {
                subStack.push(x);
            } else {
                subStack.push(subStack.peek());
            }

        }

        public void pop() {
            stack.pop();
            subStack.pop();

        }

        public int top() {
            return stack.peek();

        }

        public int min() {
            return subStack.peek();

        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}