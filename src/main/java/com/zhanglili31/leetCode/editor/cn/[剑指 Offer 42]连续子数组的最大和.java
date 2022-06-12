package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//剑指 Offer 42 连续子数组的最大和
//2022-06-12 16:14:27
class LianXuZiShuZuDeZuiDaHeLcof {

    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
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
        //前缀和超时
        public int maxSubArray2(int[] nums) {
            int sum[] = new int[nums.length];
            sum[0] = nums[0];
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < nums.length; i++) {
                sum[i] = nums[i] + sum[i - 1];
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    if (i == 0) {
                        max = Math.max(max, sum[j]);
                    } else {
                        max = Math.max(max, sum[j] - sum[i - 1]);
                    }
                }
            }
            return max;
        }

        //dp动态规划
        public int maxSubArray(int[] nums) {
            int dp[] = new int[nums.length ];
            int max = nums[0];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
                max = Math.max(max, dp[i]);
            }
            return max;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}