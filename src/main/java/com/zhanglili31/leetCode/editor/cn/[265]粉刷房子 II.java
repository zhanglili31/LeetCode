package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//265 粉刷房子 II
//2022-05-07 06:40:06
class PaintHouseIi {

    public static void main(String[] args) {
        Solution solution = new PaintHouseIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{20, 19, 11, 13, 12, 16, 16, 17, 15, 9, 5, 18}, {3, 8, 15, 17, 19, 8, 18, 3, 11, 6, 7, 12}, {15, 4, 11, 1, 18, 2, 10, 9, 3, 6, 4, 15}};
        String testStr = "hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.minCostII(a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostII(int[][] costs) {
            int column = costs.length;
            int row = column > 0 ? costs[0].length : 0;
            int dp[][] = new int[column][row];
            dp[0] = costs[0];
            for (int i = 1; i < column && row > 1; i++) {
                int min1 = dp[i - 1][0];
                int index1 = 0;
                int min2 = Integer.MAX_VALUE;
                int index2 = -1;
                for (int k = 1; k < row; k++) {
                    if (min2 > dp[i - 1][k]) {
                        min2 = dp[i - 1][k];
                        index2 = k;
                    }
                    if (min1 > min2) {
                        int temp = min1;
                        min1 = min2;
                        min2 = temp;
                        temp = index1;
                        index1 = index2;
                        index2 = temp;
                    }
                }
                for (int j = 0; j < row; j++) {
                    dp[i][j] = (j == index1 ? min2 : min1) + costs[i][j];
                }

            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < row; i++) {
                res = Math.min(res, dp[column - 1][i]);
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}