package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//329 矩阵中的最长递增路径
//2022-06-21 20:27:24
class LongestIncreasingPathInAMatrix {

    public static void main(String[] args) {
        Solution solution = new LongestIncreasingPathInAMatrix().new Solution();
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
        public int longestIncreasingPath(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int deg[] = new int[m * n];
            int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            Map<Integer, List<Integer>> edges = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < dir.length; k++) {
                        int a = dir[k][0] + i;
                        int b = dir[k][1] + j;
                        if (a >= 0 && a < m && b >= 0 && b < n && matrix[a][b] > matrix[i][j]) {
                            int x = i * n + j;
                            int y = a * n + b;
                            deg[y]++;
                            List<Integer> list = edges.getOrDefault(x, new ArrayList<>());
                            list.add(y);
                            edges.put(x, list);
                        }
                    }
                }
            }
            Map<Integer, Integer> len = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < deg.length; i++) {
                if (deg[i] == 0) {
                    queue.add(i);
                }
                len.put(i, 1);
            }
            int ans = 1;
            while (!queue.isEmpty()) {
                int x = queue.poll();
                List<Integer> list = edges.getOrDefault(x, new ArrayList<>());
                for (int i = 0; i < list.size(); i++) {
                    int y = list.get(i);
                    len.put(y, Math.max(len.get(y), len.get(x) + 1));
                    ans = Math.max(ans, len.get(y));
                    deg[y]--;
                    if (deg[y] == 0) {
                        queue.add(y);
                    }
                }
            }
            return ans;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}