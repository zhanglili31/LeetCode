package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//289 生命游戏
//2022-06-24 03:40:06
class GameOfLife {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new GameOfLife().new Solution();
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
        public void gameOfLife(int[][] board) {
            int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
            List<int[]> list = new ArrayList<>();
            int dir[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    int count = 0;
                    for (int k = 0; k < dir8.length; k++) {
                        int a = dir[k][0] + i;
                        int b = dir[k][1] + j;
                        if (a >= 0 && a < board.length && b >= 0 && b < board[i].length && board[a][b] == 1) {
                            count++;
                        }
                    }
                    if (board[i][j] == 1 && (count < 2 || count > 3)) {
                        list.add(new int[]{i, j, 0});
                    } else if (board[i][j] == 0 && count == 3) {
                        list.add(new int[]{i, j, 1});
                    }

                }
            }
            for (int i = 0; i < list.size(); i++) {
                int site[] = list.get(i);
                board[site[0]][site[1]] = site[2];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}