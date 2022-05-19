package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//562 矩阵中最长的连续1线段
//2022-05-20 00:22:57
class LongestLineOfConsecutiveOneInMatrix {

    public static void main(String[] args) {
        Solution solution = new LongestLineOfConsecutiveOneInMatrix().new Solution();
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
        int TOP = 0;
        int LEFT = 1;
        int UPPER_LEFT = 2;
        int UPPER_RIGHT = 3;
        int direction[][] = {{-1, 0}, {0, -1}, {-1, -1}, {-1, 1}};

        public int longestLine(int[][] mat) {
            int ans = 0;
            int m = mat.length;
            int n = mat[0].length;
            int dp[][][] = new int[m][n][4];

            //dp
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < direction.length && mat[i][j] == 1; k++) {
                        int x = i + direction[k][0];
                        int y = j + direction[k][1];
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            dp[i][j][k] = 1 + dp[x][y][k];
                        } else {
                            dp[i][j][k] = 1;
                        }
                        ans = Math.max(ans, dp[i][j][k]);
                    }

                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}