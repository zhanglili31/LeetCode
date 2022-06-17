package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//51 N 皇后
//2022-06-18 02:50:43
class NQueens {

    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.solveNQueens(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> ans = new ArrayList<>();
        int[][] board = null;

        public List<List<String>> solveNQueens(int n) {
            //初始化
            board = new int[n][n];
            int row[] = new int[n];
            int col[] = new int[n];
            int leftSlant[] = new int[2 * n - 1];
            int rightSlant[] = new int[2 * n - 1];
            //回溯
            DFS(0, n, row, col, leftSlant, rightSlant);
            return ans;
        }
        //正常DFS回溯
        public void DFS(int k, int n, int[] row, int[] col, int leftSlant[], int rightSlant[]) {
            if (k == n) {
                //结果保存在全局ans
                ans.add(drawBoard(board, n));
                return;
            }
            for (int j = 0; j < n; j++) {
                if (!isValid(k, j, n, row, col, leftSlant, rightSlant))
                    continue;
                row[k] = 1;
                col[j] = 1;
                int right = j - k + n - 1;
                int left = k - (n - 1 - j) + n - 1;
                leftSlant[left] = 1;
                rightSlant[right] = 1;
                board[k][j] = 1;
                DFS(k + 1, n, row, col, leftSlant, rightSlant);
                board[k][j] = 0;
                row[k] = 0;
                col[j] = 0;
                leftSlant[left] = 0;
                rightSlant[right] = 0;
            }

        }
        // 判断是否有效
        //行、列、左斜、右斜，都不等于一，
        private boolean isValid(int i, int j, int n, int[] row, int[] col, int leftSlant[], int rightSlant[]) {
            int right = j - i + n - 1;
            int left = i - (n - 1 - j) + n - 1;
            return row[i] != 1 && col[j] != 1 && leftSlant[left] != 1 && rightSlant[right] != 1;
        }
        //根据二维数组画棋盘
        private List<String> drawBoard(int[][] board, int n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) {
                        str.append('Q');
                    } else {
                        str.append('.');
                    }
                }
                list.add(str.toString());
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}