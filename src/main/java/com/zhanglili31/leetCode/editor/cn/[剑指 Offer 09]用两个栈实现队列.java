package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.Stack;

//剑指 Offer 09 用两个栈实现队列
//2022-05-16 20:35:09
class YongLiangGeZhanShiXianDuiLieLcof {

    public static void main(String[] args) {
//        Solution solution = new YongLiangGeZhanShiXianDuiLieLcof().new Solution();
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
    class CQueue {
        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            in.push(value);

        }

        public int deleteHead() {
            if (in.isEmpty()) {
                return -1;
            }
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            int ans=out.pop();
            while (!out.isEmpty()) {
                in.push(out.pop());
            }
            return ans;

        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}