package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//568 最大休假天数
//2022-05-29 18:07:34
class MaximumVacationDays {

    public static void main(String[] args) {
        Solution solution = new MaximumVacationDays().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{0, 1, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] b = {{0, 0, 7}, {2, 0, 0}, {7, 7, 7}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'j', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.maxVacationDays(a, b));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //DFS 超时
        int ans = Integer.MIN_VALUE;

        public int maxVacationDays2(int[][] flights, int[][] days) {
            int n = flights.length; //城市*城市 是否有航班0没有 1有
            int k = days[0].length;// 城市*k星期
            DFS(flights, days, k, -1, 0, 0);
            return ans;
        }

        public void DFS(int[][] flights, int[][] days, int k, int th, int p, int holidays) {
            if (th + 1 == k) {
                ans = Math.max(ans, holidays);
                return;
            }
            for (int j = 0; j < flights[p].length; j++) {
                if (flights[p][j] == 1) {
                    DFS(flights, days, k, th + 1, j, days[j][th + 1] + holidays);
                }
            }
            DFS(flights, days, k, th + 1, p, days[p][th + 1] + holidays);
        }

        public int maxVacationDays(int[][] flights, int[][] days) {
            int n = flights.length; //城市*城市 是否有航班0没有 1有
            int k = days[0].length;// 城市*k星期
            int dp[][] = new int[k][n];
            //dp[k][j]=Math.max(dp[k-1][i]//i对应可以从i飞到j的城市）+days[j][k]
            dp[0][0] = days[0][0];
            int ans = dp[0][0];
            int[][] canArrive = new int[k][n];
            canArrive[0][0] = 1;

            for (int i = 1; i < dp[0].length; i++) {
                if (flights[0][i] == 1) {
                    dp[0][i] = days[i][0];
                    ans = Math.max(ans, dp[0][i]);
                    canArrive[0][i] = 1;

                }
            }

            for (int th = 1; th < k; th++) {
                for (int j = 0; j < n; j++) {
                    int add = 0;
                    for (int f = 0; f < n; f++) {//上一个城市
                        if ((flights[f][j] == 1 || f == j) && canArrive[th - 1][f] == 1) {
                            add = Math.max(dp[th - 1][f], add);
                            canArrive[th][j]=1;
                        }
                    }
                    dp[th][j] = canArrive[th][j]== 1 ? add + days[j][th] : 0;
                    ans = Math.max(ans, dp[th][j]);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}