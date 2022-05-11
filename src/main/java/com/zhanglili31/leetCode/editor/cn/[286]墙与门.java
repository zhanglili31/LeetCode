package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.*;

//286 墙与门
//2022-05-09 05:50:38
class WallsAndGates {

    public static void main(String[] args) {
        Solution solution = new WallsAndGates().new Solution();
        TreeNode root = CreateTree.deserialize("[1,3,null,null,4]");
        int[][] a = {{0, 0}, {2, 0}, {0, 1}, {2, 1}, {0, 2}, {2, 2}, {0, 1}, {1, 2}};
        String testStr = "wo";
        String strArray[] = {"sucks", "teezmmmmteez"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution.generateAbbreviations(testStr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wallsAndGates(int[][] rooms) {
            int INF = Integer.MAX_VALUE;
            LinkedList<int[]> queue = new LinkedList<>();
            int m = rooms.length;
            if (m == 0)
                return;
            int n = rooms[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (rooms[i][j] == 0) {
                        int[] temp = {i, j};
                        queue.add(temp);
                    }
                }
            }
            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                int row = temp[0];
                int column = temp[1];
                int val = rooms[row][column];
                if (column - 1 >= 0 && rooms[row][column - 1] == INF) {
                    rooms[row][column - 1] = val + 1;
                    int add[] = {row, column - 1};
                    queue.add(add);
                }
                if (column + 1 < n && rooms[row][column + 1] == INF) {
                    rooms[row][column + 1] = val + 1;
                    int add[] = {row, column + 1};
                    queue.add(add);
                }
                if (row - 1 >= 0 && rooms[row - 1][column] == INF) {
                    rooms[row - 1][column] = val + 1;
                    int add[] = {row - 1, column};
                    queue.add(add);
                }
                if (row + 1 < m && rooms[row + 1][column] == INF) {
                    rooms[row + 1][column] = val + 1;
                    int add[] = {row + 1, column};
                    queue.add(add);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}