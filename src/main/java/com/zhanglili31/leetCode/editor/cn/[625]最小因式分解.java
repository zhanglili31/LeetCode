package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//625 最小因式分解
//2022-05-30 06:51:24
class MinimumFactorization {

    public static void main(String[] args) {
        Solution solution = new MinimumFactorization().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.smallestFactorization(48));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestFactorization(int num) {
            long res = 0;
            int mul = 1;
            if (num < 2) {
                return num;
            }
            for (int i = 9; i >= 2; i--) {
                while (num % i == 0) {
                    res += (long) i * mul;
                    mul *= 10;
                    num /= i;
                }
            }

            return num < 2 && res < Integer.MAX_VALUE ? (int) res : 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}