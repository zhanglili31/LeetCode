package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//490 迷宫
//2022-05-17 19:03:00
class TheMaze {

    public static void main(String[] args) {
        Solution solution = new TheMaze().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{0, 0, 0, 0, 1, 0, 0}, {0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.hasPath(a, new int[]{0, 0}, new int[]{8, 6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m = 0;
        int n = 0;
        int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int[][] reDirections = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
        int[][][] path;

        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            this.m = maze.length;
            this.n = maze[0].length;
            path = new int[m][n][4];

            return DFS(maze, start, destination, -1);
        }

        public boolean DFS(int[][] maze, int[] start, int[] destination, int d) {
            int a = start[0];
            int b = start[1];
            if (a == destination[0] && b == destination[1]) {
                if (d != -1 && (
                        a + direction[d][0] < 0 || a + direction[d][0] >= m
                                || b + direction[d][1] < 0 || b + direction[d][1] >= n
                                || maze[a + direction[d][0]][b + direction[d][1]] == 1
                )
                ) {
                    return true;
                }
            } else if (d != -1) {
                //标记为经过
                path[a][b][d] = -1;
            }
            boolean ans = false;
            if (d != -1 && a + direction[d][0] >= 0 && a + direction[d][0] < m && b + direction[d][1] >= 0 && b + direction[d][1] < n && maze[a + direction[d][0]][b + direction[d][1]] != 1 && path[a + direction[d][0]][b + direction[d][1]][d] != -1) {
                ans = DFS(maze, new int[]{a + direction[d][0], b + direction[d][1]}, destination, d);

            } else {
                for (int i = 0; i < direction.length; i++) {
                    if (d != -1 && reDirections[d][0] == direction[i][0] && reDirections[d][1] == direction[i][1])
                        continue;
                    int x = direction[i][0];
                    int y = direction[i][1];
                    int[] next = {a + x, b + y};
                    if (next[0] < m && next[0] >= 0 && next[1] < n && next[1] >= 0 && maze[next[0]][next[1]] == 0 && path[next[0]][next[1]][i] != -1) {
                        ans = DFS(maze, next, destination, i);
                        if (ans)
                            return ans;
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}