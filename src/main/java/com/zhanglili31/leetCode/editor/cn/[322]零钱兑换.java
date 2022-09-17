package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//322 零钱兑换
//2022-09-13 20:14:34
class CoinChange {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new CoinChange().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {2, 5, 10, 1};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.coinChange(temp, 27));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            //物品：不同的硬币
            //重量：硬币的面值
            //价值：硬币的面值
            //背包大小：amount
            int dp[][] = new int[coins.length][amount + 1];

            //初始化列：
            for (int i = 0; i < coins.length; i++) {
                dp[i][0] = 0;
            }
            //初始化行：
            for (int i = 1; i <= amount; i++) {
                dp[0][i] = i % coins[0] == 0 ? i / coins[0] : Integer.MAX_VALUE;
            }
            for (int i = 1; i < coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (coins[i] <= j && dp[i][j - coins[i]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i]] + 1);
                    }
                }
            }
            return dp[coins.length - 1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}