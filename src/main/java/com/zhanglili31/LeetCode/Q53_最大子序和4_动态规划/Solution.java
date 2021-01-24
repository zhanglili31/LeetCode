package com.zhanglili31.LeetCode.Q53_最大子序和4_动态规划;

//f(n)=max(A[n],f(n-1)+A[n]) f(n)是一定包含A[n]的连续的子数组。然后在用包含A[n]的fn和不包含A[n]的maxValue比较，得出最大值。
//执行用时： 1 ms , 在所有 Java 提交中击败了93.14%的用户
//内存消耗：38.3 MB, 在所有 Java 提交中击败了70.40%的用户
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxValue=nums[0];
        int dpn = 0;
        for (int x:nums) {
            dpn = Math.max(dpn + x, x);
            maxValue = Math.max(dpn, maxValue);
        }
        return maxValue;
    }
}
