package com.zhanglili31.LeetCode.Q209_长度最小的字数组_滑动窗口;
//前缀和的思想？？？？？也可以做。
//https://leetcode-cn.com/problems/minimum-size-subarray-sum/
public class Solution {
    public static void main(String[] args) {
        int[] nums={1,1,1,1,1};
        System.out.println(new Solution().minSubArrayLen(1,nums));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int curSum = 0;
        int curLen = 0;
        for (; right < nums.length; right++) {
            curSum += nums[right];
            for(;left<nums.length&&curSum>=target;left++){
                if (curLen == 0 || curLen > right - left) {
                    curLen = right - left+1;
                }
                curSum -= nums[left];
            }

        }
        return curLen;
    }
}
