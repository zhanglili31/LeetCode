package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//343 整数拆分
//2022-10-18 04:10:06
class IntegerBreak {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new IntegerBreak().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.integerBreak(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak(int n) {
            int dp[][] = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                dp[1][i] = i;
            }
            for (int k = 1; k <= n; k++) {//拆的个数
                for (int j = k; j <= n; j++) {//需要拆的值
                    for (int i = 1; i <= j / 2; i++) {//从1开始，知道j-1
                        dp[k][j] = Math.max(dp[k - 1][j - i] * i, dp[k][j]);
                    }
                }
            }
            int res = 0;
            for (int i = 2; i <= n; i++) {
                res = Math.max(res, dp[i][n]);
            }
            return res;
        }
    }
    //todo 优化动态规划
//leetcode submit region end(Prohibit modification and deletion)

}