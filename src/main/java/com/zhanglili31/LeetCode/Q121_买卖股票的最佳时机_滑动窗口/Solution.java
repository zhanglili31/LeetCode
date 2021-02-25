package com.zhanglili31.LeetCode.Q121_买卖股票的最佳时机_滑动窗口;


//超出了时间的限制。
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > res) res = prices[j] - prices[i];
            }
        }
        return res;
    }
}