package com.zhanglili31.LeetCode.Q53_最大子序和2;
//使用一个二维数组保存求和的数据 存在一个递推关系
// a[i][i]=nums[i];
// a[i][j]=a[i][j - 1] + nums[j];
// i<j;
//a[i][j]代表 nums[i]~nums[j]的连续子数组的和
// 未通过：超过来内存限制
public class Solution {
    public int maxSubArray(int[] nums){
        int maxValue=nums[0];
        int [][]a=new int[nums.length][nums.length];//tips：java中默认二维数组中的值是0；因此没有进一步的给二维数组初始化所有数为0。
        for (int i = 0; i < nums.length; i++) {
            a[i][i] = nums[i];
            if(maxValue<a[i][i]) maxValue = a[i][i];
            for (int j = i + 1; j < nums.length; j++) {
                a[i][j] = a[i][j - 1] + nums[j];
                if(maxValue<a[i][j]) maxValue = a[i][j];
            }
        }
        return maxValue;
    }
}
