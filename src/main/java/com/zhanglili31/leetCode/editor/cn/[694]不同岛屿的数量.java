package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//694 不同岛屿的数量
//2022-05-24 13:11:41
class NumberOfDistinctIslands {

    public static void main(String[] args) {
        Solution solution = new NumberOfDistinctIslands().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1,1,0},{0,1,1},{0,0,0},{1,1,1},{0,1,0}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.numDistinctIslands(a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Island {
            int area = 0;
            String DFSPath = new String();
        }

        int[][] tag = null;
        int[][] direction = {{-1, 0},{0, 1}, {1, 0}, {0, -1} };

        public int numDistinctIslands(int[][] grid) {
            int ans = 0;
            int m = grid.length;
            int n = grid[0].length;
            tag = new int[m][n];
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && tag[i][j] != -1) {
                        Island island = new Island();
                        DFS(grid, island, i, j, 0);
                        map.put(island.DFSPath, map.getOrDefault(island.DFSPath, 0) + 1);
                    }

                }
            }
//            Iterator iter = map.entrySet().iterator();
//            while (iter.hasNext()) {
//                Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)iter.next();
//                ans += entry.getValue();
//            }
            return map.size();
        }

        private Island DFS(int[][] grid, Island island, int a, int b, int dir) {
            if (tag[a][b] != -1 && grid[a][b] == 1) {
                island.area++;
                island.DFSPath+=dir;
                tag[a][b] = -1;
                for (int i = 0; i < direction.length; i++) {
                    int x = a + direction[i][0];
                    int y = b + direction[i][1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                        DFS(grid, island, x, y, i);
                    }
                }
                island.DFSPath += " ";
            }
            return island;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}