package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1222 可以攻击国王的皇后
//2022-06-18 05:04:03
class QueensThatCanAttackTheKing {

    public static void main(String[] args) {
        Solution solution = new QueensThatCanAttackTheKing().new Solution();
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
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            List<List<Integer>> ans = new ArrayList<>();
            int[][] board = new int[8][8];
            for (int i = 0; i < queens.length; i++) {
                board[queens[i][0]][queens[i][1]] = 1;
            }
            int dir[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
            for (int i = 0; i < dir.length; i++) {
                int a = king[0];
                int b = king[1];
                while (a >= 0 && a < 8 && b >= 0 && b < 8) {
                    a = a + dir[i][0];
                    b = b + dir[i][1];
                    if (a >= 0 && a < 8 && b >= 0 && b < 8 && board[a][b] == 1) {
                        List<Integer> list = new ArrayList<>();
                        list.add(a);
                        list.add(b);
                        ans.add(list);
                        break;
                    }
                }
            }
            return ans;

        }

        //皇后攻击国王，但是不能解决皇后前面挡者其他皇后的问题，因此反过来国王攻击皇后
        public List<List<Integer>> queensAttacktheKing2(int[][] queens, int[] king) {
            List<List<Integer>> ans = new ArrayList<>();
            int rightSlant = king[1] - king[0];
            int leftSlant = king[0] - (8 - 1 - king[1]);
            int row = king[0];
            int col = king[1];
            for (int i = 0; i < queens.length; i++) {
                int x = queens[i][0];
                int y = queens[i][1];
                int right = y - x;
                int left = x - (8 - 1 - y);
                if (x == row || y == col || right == rightSlant || left == leftSlant) {
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(y);
                    ans.add(list);
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}