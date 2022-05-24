package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//723 粉碎糖果
//2022-05-24 21:45:53
class CandyCrush {

    public static void main(String[] args) {
        Solution solution = new CandyCrush().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{110, 5, 112, 113, 114}, {210, 211, 5, 213, 214}, {310, 311, 3, 313, 314}, {410, 411, 412, 5, 414}, {5, 1, 512, 3, 3}, {610, 4, 1, 613, 614}, {710, 1, 2, 713, 714}, {810, 1, 2, 1, 1}, {1, 1, 2, 2, 2}, {4, 1, 4, 4, 1014}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.candyCrush(a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] candyCrush(int[][] board) {
            int m = board.length;
            int n = board[0].length;
            boolean flag = true;//是否发生粉碎
            int dpRow[] = new int[n];
            int dpCol[] = new int[m];
            List<int[]> po = new ArrayList<>();
            while (flag) {
                flag = false;
                //横向扫描
                po.clear();
                for (int i = 0; i < m; i++) {
                    dpRow[0] = 1;
                    for (int j = 1; j < n; j++) {
                        if (board[i][j] == 0) {
                            continue;
                        }
                        if (board[i][j] == board[i][j - 1]) {
                            dpRow[j] = dpRow[j - 1] + 1;
                        } else {
                            dpRow[j] = 1;
                        }
                        if (dpRow[j] == 3) {
                            po.add(new int[]{i, j - 2});
                            po.add(new int[]{i, j - 1});
                            po.add(new int[]{i, j});
                        } else if (dpRow[j] > 3) {
                            po.add(new int[]{i, j});
                        }
                    }
                }
                //竖向扫描
                for (int j = 0; j < n; j++) {
                    dpCol[0] = 1;
                    for (int i = 1; i < m; i++) {
                        if (board[i][j] == 0) {
                            continue;
                        }
                        if (board[i][j] == board[i - 1][j]) {
                            dpCol[i] = dpCol[i - 1] + 1;
                        } else {
                            dpCol[i] = 1;
                        }
                        if (dpCol[i] == 3) {
                            po.add(new int[]{i - 2, j});
                            po.add(new int[]{i - 1, j});
                            po.add(new int[]{i, j});
                        } else if (dpCol[i] > 3) {
                            po.add(new int[]{i, j});
                        }

                    }
                }
                //粉碎操作
                for (int i = 0; i < po.size(); i++) {
                    flag = true;
                    int[] f = po.get(i);
                    board[f[0]][f[1]] = 0;
                }
                //下降操作
                for (int j = 0; j < n && flag; j++) {
                    int pre = m - 1;
                    while (pre >= 0 && board[pre][j] != 0) {
                        pre--;
                    }
                    int pro = pre - 1;
                    while (pro >= 0 && pro < pre) {
                        while (pro >= 0 && board[pro][j] == 0) {
                            pro--;
                        }
                        if (pro >= 0) {
                            board[pre][j] = board[pro][j];
                            board[pro][j] = 0;
                            pro--;
                            pre--;
                        }

                    }
                }

            }
            return board;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}