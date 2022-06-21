package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//172 阶乘后的零
//2022-06-22 04:13:04
class FactorialTrailingZeroes {

    public static void main(String[] args) {
        Solution solution = new FactorialTrailingZeroes().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.trailingZeroes(25));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //https://leetcode.cn/problems/factorial-trailing-zeroes/solution/jie-cheng-hou-de-ling-by-leetcode-soluti-1egk/
        public int trailingZeroes2(int n) {
            int ans = 0;
            for (int i = 5; i <= n; i += 5) {

                for (int j = i; j != 0 && j % 5 == 0; j /= 5) {
                    ans++;
                }
            }
            return ans;
        }

        public int trailingZeroes(int n) {
            int ans = 0;
            while (n > 5) {
                n /= 5;
                ans += n;
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}