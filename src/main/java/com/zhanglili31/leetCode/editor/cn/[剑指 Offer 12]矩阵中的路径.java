package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//剑指 Offer 12 矩阵中的路径
//2022-06-27 01:23:22
class JuZhenZhongDeLuJingLcof {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
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
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (DFS(board, word, 0, i, j, new boolean[m][n])) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean DFS(char[][] board, String word, int k, int x, int y, boolean[][] tag) {
            if (board[x][y] != word.charAt(k)) {
                return false;
            }
            if (k + 1 == word.length()) {
                return true;
            }
            tag[x][y] = true;
            for (int i = 0; i < dir4.length; i++) {
                int a = x + dir4[i][0];
                int b = y + dir4[i][1];
                if (a >= 0 && a < board.length && b >= 0 && b < board[0].length && !tag[a][b]) {
                    if (DFS(board, word, k + 1, a, b, tag)) {
                        return true;
                    }
                }

            }
            tag[x][y] = false;
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}