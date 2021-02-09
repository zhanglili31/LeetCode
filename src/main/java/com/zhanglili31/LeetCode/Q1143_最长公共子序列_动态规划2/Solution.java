package com.zhanglili31.LeetCode.Q1143_最长公共子序列_动态规划2;
//这个连接中的解答思路很清晰
// https://leetcode-cn.com/problems/longest-common-subsequence/solution/dong-tai-gui-hua-tu-wen-jie-xi-by-yijiaoqian/
public class Solution {
    public int longestCommonSubsequence(String text1, String text2){
        int maxValue=0;
        int [][] dp=new int[text1.length()+1][text2.length()+1];
        char ch1;
        char ch2;
        for (int i = 1; i < text1.length()+1; i++) {
            for (int j = 1; j < text2.length()+1; j++) {
                char c1 = text1.charAt(i - 1);
                char c2 = text2.charAt((j - 1));
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1]+1;//这个子串中包含了这一项所以+1，在加上都不包含这一项的两个子串的长度。
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if(dp[i][j]>maxValue) maxValue = dp[i][j];
            }
        }
        return maxValue;
    }
}
