package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//50 Pow(x, n)
//2022-06-02 03:14:16
class PowxN {

    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //https://leetcode.cn/problems/powx-n/solution/powx-n-by-leetcode-solution/
        public double myPow(double x, int n) {
            if (x == 0.0) {
                return 0;
            }
            if (n == 0) {
                return 1;
            }
            if (n < 0) {
                x = 1 / x;
            }
            return recursion(x, n);
        }

        public double recursion(double x, int n) {
            if (n == 0) {
                return 1;
            } else if (n == 1) {
                return x;
            }
            double y = recursion(x, n / 2);
            if (n % 2 == 0) {
                return y*y;
            }else{
                return y*y*x;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}