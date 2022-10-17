package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//994 腐烂的橘子
//2022-10-17 03:38:43
class RottingOranges {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        Solution solution = new RottingOranges().new Solution();
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
        public int orangesRotting(int[][] grid) {
            int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            Queue<Queue<int[]>> queue = new LinkedList<>();
            Queue<int[]> init = new LinkedList<>();
            int freshNum = 0;
            int m = grid.length;
            int n = grid[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        init.add(new int[]{i, j});
                    } else if (grid[i][j] == 1) {
                        freshNum++;
                    }
                }
            }

            queue.add(init);

            int res = 0;

            while (!queue.isEmpty() && freshNum > 0) {
                res++;
                Queue<int[]> q = queue.poll();
                Queue<int[]> temp = new LinkedList<>();
                while (!q.isEmpty()) {
                    int[] po = q.poll();
                    for (int i = 0; i < dir4.length; i++) {
                        int x = po[0] + dir4[i][0];
                        int y = po[1] + dir4[i][1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            freshNum--;
                            if (freshNum == 0) {
                                return res;
                            }
                            grid[x][y] = 2;
                            temp.add(new int[]{x, y});
                        }
                    }
                }
                if (!temp.isEmpty()) {
                    queue.add(temp);
                }
            }
            return freshNum == 0 ? res : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}