package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//256 粉刷房子
//2022-05-07 02:51:29
class PaintHouse {

    public static void main(String[] args) {
        Solution solution = new PaintHouse().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int[][] costs) {
            int n = costs.length;
            int res = 0;
            int dp[][] = new int[n][3];
            dp[0] = costs[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
            return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}