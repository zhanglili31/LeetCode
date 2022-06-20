package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//29 两数相除
//2022-06-20 20:06:43
class DivideTwoIntegers {

    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.divide(2147483647, -1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //暴力模拟，
        //最终结果的符号是由factor决定的
        //两个都转为负数，比较方便coding
        public int divide2(int dividend, int divisor) {
            int ans = 0;
            int factor = 1;
            if (divisor > 0 && dividend < 0 || divisor < 0 && dividend > 0) {
                factor = -1;
            }
            dividend = -Math.abs(dividend);
            divisor = -Math.abs(divisor);
            int sum = 0;
            while (sum + divisor >= dividend) {
                sum += divisor;
                ans += factor;
                if (ans <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                if (ans >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }

            return ans;
        }
        public int divide(int dividend, int divisor) {
            int ans = 0;
            int factor = 1;
            if (divisor > 0 && dividend < 0 || divisor < 0 && dividend > 0) {
                factor = -1;
            }
            dividend = -Math.abs(dividend);
            divisor = -Math.abs(divisor);
            ans = recursion(dividend, divisor, factor);
            return ans;
        }
        private int recursion(int dividend, int divisor, int factor) {
            if (divisor<dividend) {
                return 0;
            }
            int ans = factor;
            int sum = divisor;
            while (sum>=Integer.MIN_VALUE/2&&sum + sum >= dividend) {
                if (ans > 0 && ans + ans == Integer.MIN_VALUE) {
                    return Integer.MAX_VALUE;
                }
                ans += ans;
                sum += sum;
            }
            ans += recursion(dividend - sum, divisor, factor);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}