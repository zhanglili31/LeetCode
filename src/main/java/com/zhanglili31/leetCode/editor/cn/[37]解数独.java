package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//37 解数独
//2022-10-16 03:13:43
class SudokuSolver {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new SudokuSolver().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
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
        Map<Integer, Set<Character>> rowMap = new HashMap<Integer, Set<Character>>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> gridMap = new HashMap<>();
        boolean flag = false;

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                rowMap.put(i, new HashSet<>());
                colMap.put(i, new HashSet<>());
                gridMap.put(i, new HashSet<>());
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        Set<Character> rowSet = rowMap.get(i);
                        Set<Character> colSet = colMap.get(j);
                        Set<Character> gridSet = gridMap.get(getIndex(i, j));
                        rowSet.add(board[i][j]);
                        colSet.add(board[i][j]);
                        gridSet.add(board[i][j]);
                    }
                }
            }
            DFS(board, 0);


        }

        private void DFS(char[][] board, int index) {
            if (index == 81) {
                flag = true;
                return;
            }
            int x = index / 9;
            int y = index % 9;
            if (board[x][y] != '.') {
                DFS(board, index + 1);
                return;
            }
            for (int i = 1; i <= 9; i++) {
                char ch = (char) (i + '0');
                Set<Character> rowSet = rowMap.get(x);
                Set<Character> colSet = colMap.get(y);
                Set<Character> gridSet = gridMap.get(getIndex(x, y));
                if (rowSet.contains(ch) || colSet.contains(ch) || gridSet.contains(ch)) {
                    continue;
                }
                rowSet.add(ch);
                colSet.add(ch);
                gridSet.add(ch);
                board[x][y] = ch;
                DFS(board, index + 1);
                if (flag) {
                    return;
                }
                board[x][y] = '.';
                rowSet.remove(ch);
                colSet.remove(ch);
                gridSet.remove(ch);
            }

        }


        private int getIndex(int x, int y) {
            int row = x / 3;
            int col = y / 3;
            return row * 3 + col;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}