package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//518 零钱兑换 II
//2022-06-19 00:29:59
class CoinChange2 {

    public static void main(String[] args) {
        Solution solution = new CoinChange2().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {1, 2, 5};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.change(5, temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //dp[i]=sum(dp[i-coins[i]])
        public int change(int amount, int[] coins) {
            int dp[] = new int[amount + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int i = coin; i<= amount; i++) {
                    dp[i] += dp[i - coin];
                }
            }
            return dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}