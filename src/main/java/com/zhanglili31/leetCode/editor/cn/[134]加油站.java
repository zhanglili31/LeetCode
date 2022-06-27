package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//134 加油站
//2022-06-25 06:55:36
class GasStation {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new GasStation().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {1, 2, 3, 4, 5};
        int temp2[] = {3, 4, 5, 1, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.canCompleteCircuit(temp, temp2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 正常模拟
        public int canCompleteCircuit2(int[] gas, int[] cost) {
            int n = gas.length;
            for (int i = 0; i < n; i++) {
                cost[i] = gas[i] - cost[i];
            }
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = i; j < i + n && sum >= 0; j++) {
                    sum += cost[j % n];
                }
                if (sum >= 0) {
                    return i;
                }
            }
            return -1;
        }

        //动态规划
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int dp[][] = new int[2 * n][n * 2 + 1];
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                cost[i] = gas[i] - cost[i];
                dp[i][i + 1] = cost[i];
                dp[i + n][i + n + 1] = cost[i];
                if (dp[i][i + 1] >= 0) {
                    set.add(i);
                }
            }

            for (int len = 2; len <= n; len++) {
                Set<Integer> temp = new HashSet<>();
                for (Integer i : set) {
                    int tar = i + len;
                    int pre = tar - 1;
                    dp[i][tar] = dp[i][pre] + dp[tar - 1][tar];
                    if (dp[i][tar] >= 0) {
                        temp.add(i);
                        if (len == n) {
                            return i;
                        }
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}