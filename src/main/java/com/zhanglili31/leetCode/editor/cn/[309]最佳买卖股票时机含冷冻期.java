package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//309 最佳买卖股票时机含冷冻期
//2022-05-03 01:11:29
class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = {1,7,4};
        System.out.println(solution.maxProfit(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int status=1; //1 可买，2 可卖  3 冷冻 不能卖，不能买.
        private int maxValue=Integer.MIN_VALUE;
        public int maxProfit(int[] prices) {
            if(prices.length<2)return 0;
            int[][] dp = new int[prices.length][5];
            //0 买，1 不买，2卖 3不卖
            dp[0][0] = -prices[0];

            dp[1][0] = -prices[1];
            dp[1][1] = 0;
            dp[1][2] = prices[1] - prices[0];
            dp[1][3] = -prices[0];

            for (int i = 2; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i -2][2]) - prices[i];//买
                dp[i][1] = Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]),dp[i-2][2]);  //不买
                dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][3]) + prices[i]; //卖
                dp[i][3]=Math.max(dp[i-1][0],dp[i-1][3]); //不卖
            }
            for (int i = 0; i < 5; i++) {
                if (maxValue < dp[prices.length - 1][i]) {
                    maxValue = dp[prices.length - 1][i];
                }
            }
            return maxValue;

        }

        //DFS
        public int maxProfit2(int[] prices) {
            DFS(prices, 0, 1, 0);
            return maxValue;

        }
        public void DFS(int[] prices, int index, int status,int curVal) {
            if(index==prices.length){
                System.out.println(curVal);
                if (curVal > maxValue) {
                    maxValue=curVal;
                }
                return;
            }
            if(status==1){
                //买
                DFS(prices, index + 1, 2, curVal - prices[index]);
                //不买
                DFS(prices, index + 1, status, curVal);
            }else if(status==2){
                //卖
                DFS(prices, index + 1, 3, curVal + prices[index]);
                //不卖
                DFS(prices, index + 1, status, curVal);
            }else{
                DFS(prices, index + 1, 1, curVal);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}