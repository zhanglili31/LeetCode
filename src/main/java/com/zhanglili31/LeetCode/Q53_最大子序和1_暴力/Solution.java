package com.zhanglili31.LeetCode.Q53_最大子序和1_暴力;
//    使用暴力的方法，将所有的连续的子数组全部找出来，并且求和找出最大的出来
//    未通过：超出时间限制
public class Solution {
    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        int res = solution.maxSubArray(a);
        System.out.println(res);
    }
    public int maxSubArray(int[] nums) {
        int maxValue = nums[0];
        int temp = 0;
        for (int i = nums.length; i > 0; i--) {//每轮循环中包含的子数组的个数
            for (int j = 0; j <= nums.length - i; j++) {//每轮循环的起始位置
                for (int k = 0; k < i; k++) {//k代表每次求和的连续子数组
                    temp += nums[k + j];
                }
                if (temp > maxValue) {
                    maxValue = temp;
                }
                temp = 0;
            }

        }
        return maxValue;

    }

}