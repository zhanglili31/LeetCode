package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//1066 校园自行车分配 II
//2022-06-08 06:26:24
class CampusBikesIi {

    public static void main(String[] args) {
        Solution solution = new CampusBikesIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{815, 60}, {638, 626}};
        int[][] b = {{709,161},{341,339},{755,955}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.assignBikes(a,b));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = Integer.MAX_VALUE;

        public int assignBikes(int[][] workers, int[][] bikes) {
            int n = workers.length;
            int m = bikes.length;
            int distance[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                int wx = workers[i][0];
                int wy = workers[i][1];
                for (int j = 0; j < m; j++) {
                    int bx = bikes[j][0];
                    int by = bikes[j][1];
                    distance[i][j] = Math.abs(wx - bx) + Math.abs(wy - by);
                }
            }
            Set<Integer> choseBikes = new HashSet<>();
            traceBack(distance, 0, 0, choseBikes);
            return ans;

        }

        public void traceBack(int[][] d, int sum, int k, Set<Integer> choseBikes) {
            if (k == d.length) {
                ans = Math.min(sum, ans);
                return;
            }
            if (sum >= ans) {
                return;
            }
            for (int i = 0; i < d[k].length; i++) {
                if (choseBikes.contains(i))
                    continue;
                choseBikes.add(i);
                traceBack(d, sum + d[k][i], k + 1, choseBikes);
                choseBikes.remove(i);
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}