package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//361 轰炸敌人
//2022-05-13 12:30:47
class BombEnemy {

    public static void main(String[] args) {
        Solution solution = new BombEnemy().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.maxKilledEnemies(new char[][]{{'W','W','W','W','E'},{'W','E','E','E','E'},{'W','E','0','E','0'},{'W','E','E','E','E'},{'W','W','W','W','W'}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m, n;
        int COL = 1;
        int ROW = 0;

        public int maxKilledEnemies(char[][] grid) {
            int ans=0;
            m = grid.length;
            n = grid[0].length;
            int dp[][][] = new int[m][n][2];
            int t = m+n-1;
            int i = 0, j = 0;
            for (int k = 0; k < t; k++) {
                if (k < n) {
                    i = 0;
                    j = k;
                } else {
                    i = k - n + 1;
                    j = n - 1;
                }
                for (; i < m && j >= 0; i++, j--) {
                    if (grid[i][j] == 'W')
                        continue;
                    int top = 0;
                    int left = 0;
                    if (i - 1 >= 0 && grid[i - 1][j] != 'W') {
                        top = dp[i - 1][j][COL];
                    } else {
                        top = count(grid, i, j, COL);
                    }

                    if (j - 1 >= 0 && grid[i][j - 1] != 'W') {
                        left = dp[i ][j-1][ROW];
                    } else {
                        left = count(grid, i, j, ROW);
                    }
                    int res[] = new int[2];
                    res[COL] = top;
                    res[ROW] = left;
                    dp[i][j]=res;
                    if (grid[i][j] == '0') {
                        ans = Math.max(ans, top + left);
                    }


                }
            }
            return ans;


        }

        public int count(char[][] grid, int row, int column, int dir) {
            int res = 0;
            if (dir == ROW) {
                for (int i = column; i < n; i++) {
                    if (grid[row][i] == 'E') {
                        res += 1;
                    } else if (grid[row][i] == 'W') {
                        break;
                    }
                }
            } else {
                for (int i = row; i < m; i++) {
                    if (grid[i][column] == 'E') {
                        res += 1;
                    } else if (grid[i][column] == 'W') {
                        break;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}