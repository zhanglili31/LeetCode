package com.zhanglili31.leetCode.Q300_最长递增子序列_动态规划2;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        List<Integer> level = new ArrayList<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            for(int j=0;;j++){
                if (j >=level.size()) {
                    level.add(nums[i]);
                    break;
                }
                if(nums[i]>=level.get(j)){//替换，
                    level.set(j, nums[i]);
                    break;
                }
            }
        }
        return level.size();

    }
}
