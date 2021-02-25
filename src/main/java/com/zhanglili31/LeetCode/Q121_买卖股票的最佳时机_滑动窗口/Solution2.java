package com.zhanglili31.LeetCode.Q121_买卖股票的最佳时机_滑动窗口;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minHistory=Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
           if(prices[i]<minHistory) minHistory = prices[i];
            if (res < prices[i] - minHistory) {
                res=prices[i]-minHistory;
            }
        }
        return res;
    }
}
