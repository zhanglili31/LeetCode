package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//130 被围绕的区域
//2022-06-18 23:44:03
class SurroundedRegions {

    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[][] charArray = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        solution.solve(charArray);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solve(char[][] board) {
            int m = board.length;
            int n = board[0].length;
            boolean cantFill[][] = new boolean[m][n];
            Queue<int[]> queue = new LinkedList<int[]>();
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O') {
                    queue.add(new int[]{i, 0});
                }
                if (board[i][n - 1] == 'O') {
                    queue.add(new int[]{i, n - 1});
                }
            }
            for (int j = 1; j < n - 1; j++) {
                if (board[0][j] == 'O') {
                    queue.add(new int[]{0, j});
                }
                if (board[m - 1][j] == 'O') {
                    queue.add(new int[]{m - 1, j});
                }
            }
            int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            while (!queue.isEmpty()) {
                int cur[] = queue.poll();
                cantFill[cur[0]][cur[1]] = true;
                for (int i = 0; i < dir.length; i++) {
                    int x = cur[0] + dir[i][0];
                    int y = cur[1] + dir[i][1];
                    if (x >= 0 && x < m && y >= 0 && y < n && cantFill[x][y] == false && board[x][y] == 'O') {
                        queue.add(new int[]{x, y});
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!cantFill[i][j]) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}