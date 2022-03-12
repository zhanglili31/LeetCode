package com.zhanglili31.leetCode.editor.cn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int res=0;
    public int findTargetSumWays(int[] nums, int target) {
        recursion(nums, 0, target, 0);
        return res;

    }
    //深度遍历，
    void recursion(int[] nums, int index, int target,int curVal) {
        int len = nums.length;
        if(index==len){
            if (curVal==target) {
                res++;
            }
            return;
        }
        recursion(nums, index + 1, target, curVal + nums[index]);
        recursion(nums, index + 1, target, curVal - nums[index]);
    }

    //动态规划 dp[ i ][ j ] = dp[ i - 1 ][ j - nums[ i ] ] + dp[ i - 1 ][ j + nums[ i ] ]
    void useDp(int nums[], int target) {
        int dp[][] = new int[1001][1001];
        for (int i = 0; i < nums.length; i++) {

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
