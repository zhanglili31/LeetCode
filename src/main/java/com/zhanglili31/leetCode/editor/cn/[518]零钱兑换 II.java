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
        //一维度动态 ，
        public int change1(int amount, int[] coins) {
            int dp[] = new int[amount + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] += dp[i - coin];
                }
            }
            return dp[amount];
        }//

        public int change(int amount, int[] coins) {
            //背包：amount
            //重量：每一个面额不同的amount
            //价值：面额
            int dp[][] = new int[coins.length][amount + 1];
            //初始化列
            for (int i = 0; i < coins.length; i++) {
                dp[i][0] = 1;
            }
            //初始化行
            for (int i = 1; i <= amount; i++) {
                dp[0][i] = i % coins[0] == 0 ? 1 : 0;
            }
            for (int i = 1; i < coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (coins[i] <= j ) {
                        dp[i][j] += dp[i][j - coins[i]];
                    }
                }
            }
            return dp[coins.length - 1][amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}