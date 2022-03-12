package com.zhanglili31.leetCode.Q53_最大子序和3_二维数组动态规划优化_使用变量代替二维数组;
//在接解法2的基础上直接使用一个变量代替二位数组
//实际中不需要使用一个二位数组，使用一个变量即可

//执行用时：168 ms, 在所有 Java 提交中击败了5.00%的用户
//内存消耗：38.4 MB, 在所有 Java 提交中击败了53.24%的用户
public class Solution {
    public int maxSubArray(int[] nums){
        int maxValue=nums[0];
        int temp=0;
        int next=0;
        for (int i = 0; i < nums.length; i++) {
            temp= nums[i];
            if(maxValue<temp) maxValue = temp;
            for (int j = i + 1; j < nums.length; j++) {
                next = temp + nums[j];
                if(maxValue<next) maxValue = next;
                temp=next;
            }
        }
        return maxValue;
    }
}