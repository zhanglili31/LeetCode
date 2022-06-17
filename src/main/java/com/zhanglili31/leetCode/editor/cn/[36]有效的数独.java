package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//36 有效的数独
//2022-06-18 01:34:40
class ValidSudoku {

    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
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
        //普通的做法，需要三次遍历
        public boolean isValidSudoku2(char[][] board) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    } else if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
                set.clear();
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[j][i] == '.') {
                        continue;
                    } else if (set.contains(board[j][i])) {
                        return false;
                    }
                    set.add(board[j][i]);
                }
                set.clear();
            }
            for (int i = 0; i < board.length; i += 3) {
                for (int j = 0; j < board[i].length; j += 3) {
                    set.clear();
                    for (int k = i; k < i + 3; k++) {
                        for (int t = j; t < j + 3; t++) {
                            if (board[k][t] == '.') {
                                continue;
                            } else if (set.contains(board[k][t])) {
                                return false;
                            }
                            set.add(board[k][t]);
                        }
                    }
                }
            }
            return true;
        }

        //todo：还能在优化：用数组代替hash表还能再快
        //一次遍历，每一个唯独建立hastset判断
        public boolean isValidSudoku(char[][] board) {
            Map<Integer, Set<Character>> row = new HashMap<>();
            Map<Integer, Set<Character>> col = new HashMap<>();
            Map<Integer, Set<Character>> box = new HashMap<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    //行
                    Set<Character> rowSet = row.getOrDefault(i, new HashSet<>());
                    if (rowSet.contains(board[i][j]))
                        return false;
                    rowSet.add(board[i][j]);
                    row.put(i, rowSet);

                    //列
                    Set<Character> colSet = col.getOrDefault(j, new HashSet<>());
                    if (colSet.contains(board[i][j]))
                        return false;
                    colSet.add(board[i][j]);
                    col.put(j, colSet);

                    //盒子
                    int tar = (i / 3) * 9 + (j / 3) * 3;
                    Set<Character> boxSet = box.getOrDefault(tar, new HashSet<>());
                    if (boxSet.contains(board[i][j]))
                        return false;
                    boxSet.add(board[i][j]);
                    box.put(tar, boxSet);
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}