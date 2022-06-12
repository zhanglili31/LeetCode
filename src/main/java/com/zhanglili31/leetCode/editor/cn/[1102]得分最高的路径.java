package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//1102 得分最高的路径
//2022-06-12 11:26:20
class PathWithMaximumMinimumValue {

    public static void main(String[] args) {
        Solution solution = new PathWithMaximumMinimumValue().new Solution();
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
        //https://leetcode.cn/problems/path-with-maximum-minimum-value/solution/java-dfs-er-fen-by-gaaakki/
        public int maximumMinimumPath(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            Queue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[2] - o1[2];
                }
            });
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            priorityQueue.add(new int[]{0, 0, grid[0][0]});
            int sign[][] = new int[m][n];
            int ans = Integer.MAX_VALUE;
            while (!priorityQueue.isEmpty()) {
                int[] a = priorityQueue.poll();
                sign[a[0]][a[1]] = 1;
                System.out.println(Arrays.toString(a));
                ans = Math.min(a[2], ans);
                if(a[0]==m-1&&a[1]==n-1)break;
                for (int i = 0; i < directions.length; i++) {
                    int x = a[0] + directions[i][0];
                    int y = a[1] + directions[i][1];
                    if (x < 0 || x >= m || y < 0 || y >= n || sign[x][y] == 1) {
                        continue;
                    }
                    priorityQueue.add(new int[]{x, y, grid[x][y]});

                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}