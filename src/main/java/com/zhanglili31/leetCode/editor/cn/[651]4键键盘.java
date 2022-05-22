package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//651 4键键盘
//2022-05-22 21:17:45
class FourKeysKeyboard {

    public static void main(String[] args) {
        Solution solution = new FourKeysKeyboard().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.maxA(7));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxA(int n) {
            if (n <= 3) {
                return n;
            }
            int dp[] = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            dp[2] = 3;
            dp[3] = 4;
            for (int i = 4; i < n; i++) {
                dp[i] = Math.max(dp[i - 1] + 1, dp[i - 3] * 2);
                dp[i] = Math.max(dp[i], dp[i - 4] * 3);
                if (i - 5 > 0)
                    dp[i] = Math.max(dp[i], dp[i - 5] * 4);
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}