package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//573 松鼠模拟
//2022-05-20 01:17:30
class SquirrelSimulation {

    public static void main(String[] args) {
        Solution solution = new SquirrelSimulation().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
            int ans = Integer.MAX_VALUE;
            int sum=0;
            for (int i = 0; i < nuts.length; i++) {
                sum += (Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1] - nuts[i][1])) * 2;
            }
            for (int i = 0; i < nuts.length; i++) {
                int temp = Math.abs(squirrel[0] - nuts[i][0]) + Math.abs(squirrel[1] - nuts[i][1]) - (Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1] - nuts[i][1])) + sum;
                ans = Math.min(temp, ans);
            }
            return ans;

        }

        //BFS  ,不需要BFS
        public int findSquirrelToNutsShortestPathLength(int m, int n, int[] squirrel, int[][] nuts, int tree[]) {
            int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int[][] path = new int[m][n];
            int[][] nutsPoi = new int[m][n];
            for (int i = 0; i < nuts.length; i++) {
                nutsPoi[nuts[i][0]][nuts[i][1]] = 1;
            }
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.add(squirrel);
            while (!queue.isEmpty()) {
                int po[] = queue.poll();
                for (int i = 0; i < direction.length; i++) {
                    int x = direction[i][0] + po[0];
                    int y = direction[i][1] + po[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && path[x][y] == 0) {
                        if (nutsPoi[x][y] != 0) {
                            return 1 + path[po[0]][po[1]] - ((Math.abs(tree[0] - x) + Math.abs(tree[1] - y)));
                        }
                        path[x][y] = path[po[0]][po[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}