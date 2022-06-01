package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//644 子数组最大平均数 II
//2022-06-01 00:19:00
class MaximumAverageSubarrayIi {

    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubarrayIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //前缀和 超时
        public double findMaxAverage2(int[] nums, int k) {
            int[] preSum = new int[nums.length];
            preSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i];
            }
            double ans = Double.MIN_VALUE;
            for (int i = 0; i <= nums.length - k; i++) {
                for (int j = i + k - 1; j < nums.length; j++) {
                    double len = (double) j - i + 1;
                    double sum = preSum[j] - preSum[i] + nums[i];
                    double d = sum / len;
                    if (ans == Double.MIN_VALUE || ans < d) {
                        ans = d;
                    }
                }
            }
            return ans;
        }

        //参考：https://leetcode.cn/problems/maximum-average-subarray-ii/solution/zui-da-ping-jun-zi-duan-he-ii-by-leetcode/
        public double findMaxAverage(int[] nums, int k) {
            double error;
            double min = Integer.MAX_VALUE;
            double max = Integer.MIN_VALUE;
            for (int i : nums) {
                min = Math.min(i, min);
                max = Math.max(i, max);
            }
            double mid = 0.0;
            error = Integer.MAX_VALUE;
            double prev = max;
            while (error > 0.00001) {
                mid = (min + max) * 0.5;
                if (check(nums, mid, k)) {
                    min = mid;
                } else {
                    max = mid;
                }
                error = Math.abs(prev - mid);
                prev = min;
            }
            return min;
        }

        public boolean check(int[] nums, double mid, int k) {
            double sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i] - mid;
            }
            if (sum >= 0) {
                return true;
            }
            double prev = 0;
            double minVal = 0;
            for (int i = k; i < nums.length; i++) {
                sum += nums[i] - mid;
                prev += nums[i - k] - mid;
                minVal = Math.min(minVal, prev);
                if (sum >= minVal) {
                    return true;
                }
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}