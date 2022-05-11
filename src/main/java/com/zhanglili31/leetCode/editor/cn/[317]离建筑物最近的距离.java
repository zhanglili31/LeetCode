package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//317 离建筑物最近的距离
//2022-05-11 08:27:57
class ShortestDistanceFromAllBuildings {

    public static void main(String[] args) {
        Solution solution = new ShortestDistanceFromAllBuildings().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 0, 2, 0, 1}, {2, 2, 2, 2, 2}, {0, 0, 1, 0, 0}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.shortestDistance(a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //参考：https://leetcode.cn/problems/shortest-distance-from-all-buildings/solution/cbfszui-you-jie-fa-zhi-xing-yong-shi-8msnei-cun-xi/
        public int shortestDistance(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int res = Integer.MAX_VALUE;
            int val = 0;//表示空地
            int distance[][] = new int[m][n];
            int sum[][] = new int[m][n];
            Queue<int[]> queue = new LinkedList<int[]>();
            int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 1) {
                        continue;
                    }
                    queue.add(new int[]{i, j});
                    res = Integer.MAX_VALUE;
                    while (!queue.isEmpty()) {
                        int[] position = queue.poll();
                        int a = position[0];
                        int b = position[1];
                        for (int k = 0; k < direction.length; k++) {
                            int x = a + direction[k][0];
                            int y = b + direction[k][1];
                            if (0 <= x && x < m && 0 <= y && y < n && grid[x][y] == val) {//当存在障碍的时候，grid[x][y]!=val,
                                grid[x][y]--;
                                distance[x][y] = distance[a][b] + 1;
                                sum[x][y] += distance[x][y];
                                res = Math.min(res, sum[x][y]);
                                queue.add(new int[]{x, y});
                            }
                        }

                    }
                    val--;
                    if (res == Integer.MAX_VALUE)
                        return -1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}