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
        int m = 0;
        int n = 0;
        int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            this.m = maze.length;
            this.n = maze[0].length;
            return DFS(maze, start, destination, null);
        }

        public boolean DFS(int[][] maze, int[] start, int[] destination, int[] dir) {
            int a = start[0];
            int b = start[1];
            if (a == destination[0] && b == destination[1]) {
                if (dir != null && (
                        a + dir[0] < 0 || a + dir[0] >= m
                                || b + dir[1] < 0 || b + dir[1] >= n
                                || maze[a + dir[0]][b + dir[1]] == 1
                )
                ) {
                    return true;
                }
            }else{
                //标记为经过
                maze[a][b] = -1;
            }

            boolean ans = false;
            for (int i = 0; i < direction.length; i++) {
                int x = direction[i][0];
                int y = direction[i][1];
                int[] next = {a + x, b + y};
                if (next[0] < m && next[0] >= 0 && next[1] < n && next[1] >= 0 && maze[next[0]][next[1]] == 0) {
                    ans = DFS(maze, next, destination, direction[i]);
                    if (ans)
                        return ans;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}