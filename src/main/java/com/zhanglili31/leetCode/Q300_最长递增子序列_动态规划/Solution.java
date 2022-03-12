package com.zhanglili31.leetCode.Q300_最长递增子序列_动态规划;
//使用dp[n],记录每一个位置的最长递增子序列，对于后面的数组来说，就是遍历前面所有比自己小的数，对应的最大dp[i],然后加一。
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxDp=0;
        int maxLength=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(nums[j]>=nums[i]){
                    continue;
                }else{
                    if(dp[j]>maxDp) maxDp = dp[j];
                }
            }
            dp[i]=maxDp+1;
            if(dp[i]>maxLength) maxLength = dp[i];
            maxDp=0;
        }
        return maxLength;
    }
}
