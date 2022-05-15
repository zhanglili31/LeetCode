package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//487 最大连续1的个数 II
//2022-05-15 23:51:52
class MaxConsecutiveOnesIi {

    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnesIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int NOT_REVERSE = 0;
            int REVERSE = 1;
            int dp[][] = new int[nums.length][2];
            int ans = 1;
            if (nums[0] == 0) {
                dp[0][NOT_REVERSE] = 0;
            } else {
                dp[0][NOT_REVERSE] = 1;
            }
            dp[0][REVERSE] = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0) {
                    dp[i][NOT_REVERSE] = 0;
                    dp[i][REVERSE] = dp[i - 1][NOT_REVERSE] + 1;
                } else {
                    dp[i][NOT_REVERSE] = dp[i - 1][NOT_REVERSE] + 1;
                    dp[i][REVERSE] = dp[i - 1][REVERSE] + 1;
                }
                ans = Math.max(ans, Math.max(dp[i][REVERSE], dp[i][NOT_REVERSE]));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}