package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//45 跳跃游戏 II
//2022-06-20 05:35:02
class JumpGameIi {

    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
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
        public int jump(int[] nums) {
            int dp[] = new int[nums.length];
            for (int i = 1; i < dp.length; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j < dp.length) {
                        dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                    }

                }
            }
            return dp[nums.length - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}