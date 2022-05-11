package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//348 设计井字棋
//2022-05-11 16:32:29
class DesignTicTacToe {

    public static void main(String[] args) {
//        Solution solution = new DesignTicTacToe().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        TicTacToe t = new TicTacToe(3);
//        t.move(0, 0, 1);
//        t.move(0, 2, 2);
//        t.move(2, 2, 1);
        System.out.println();

//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //参考解决方案
    class TicTacToe {
        int row[][] = null;
        int col[][] = null;
        int x1[] = new int[2];
        int x2[] = new int[2];
        int n = 0;

        public TicTacToe(int n) {
            row = new int[2][n];
            col = new int[2][n];
            this.n = n;


        }

        public int move(int row, int col, int player) {
            int points = player - 1;
            this.row[points][row] += player;
            this.col[points][col] += player;
            int target = n * player;
            if (this.row[points][row] == target || this.col[points][col] == target) {
                return player;
            }
            if (row == col) {
                x1[points] += player;
                if (x1[points] == target) {
                    return player;
                }
            }
            if (row == n - 1 - col) {
                x2[points] += player;
                if (x2[points] == target) {
                    return player;
                }
            }
            return 0;


        }
    }

    class TicTacToe2 {
        int[][] checkerboard = null;
        int n = 0;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        boolean x1 = true;
        boolean x2 = true;


        public TicTacToe2(int n) {
            this.n = n;
            checkerboard = new int[n][n];
        }

        public int move(int row, int col, int player) {
            Object o = this;
            checkerboard[row][col] = player;
            boolean rowOK = !this.row.contains(row);
            for (int i = 0; i < n && rowOK; i++) {
                if (checkerboard[row][i] != player) {
                    rowOK = false;
                    if (checkerboard[row][i] != 0) {
                        this.row.add(row);
                    }
                }
            }
            if (rowOK)
                return player;
            boolean colOK = !this.col.contains(col);
            for (int i = 0; i < n && colOK; i++) {
                if (checkerboard[i][col] != player) {
                    colOK = false;
                    if (checkerboard[i][col] != 0) {
                        this.col.add(col);
                    }
                }
            }
            if (colOK)
                return player;
            if (row == col) {
                boolean bx1 = this.x1;
                for (int i = 0; i < n && bx1; i++) {
                    if (checkerboard[i][i] != player) {
                        bx1 = false;
                        if (checkerboard[i][i] != 0) {
                            this.x1 = false;
                        }
                    }
                }
                if (bx1)
                    return player;
            }
            if (row == n - 1 - col) {
                boolean bx2 = this.x2;
                for (int i = 0; i < n && bx2; i++) {
                    if (checkerboard[n - i - 1][i] != player) {
                        bx2 = false;
                        if (checkerboard[n - i - 1][i] != 0) {
                            this.x2 = false;
                        }
                    }
                }
                if (bx2)
                    return player;
            }


            return 0;
        }
    }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
//leetcode submit region end(Prohibit modification and deletion)

}