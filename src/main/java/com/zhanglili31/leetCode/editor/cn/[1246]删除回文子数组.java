package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1246 删除回文子数组
//2022-06-16 16:40:18
class PalindromeRemoval {

    public static void main(String[] args) {
        Solution solution = new PalindromeRemoval().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {1, 2, 1, 1, 3, 1};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.minimumMoves(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //https://leetcode.cn/problems/palindrome-removal/solution/qu-jian-dp-by-hkskkazeo/
        //1 删除(i,k)+(k+1,j)最小的
        //2 删除（i+1,j-1) 最小（）arr[i]==arr[j]的情况
        //求1和2  情况的最小
        public int minimumMoves(int[] arr) {
            if (arr.length < 2) {
                return arr.length;
            }
            int n = arr.length;
            int dp[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    dp[i][i + 1] = 1;
                } else {
                    dp[i][i + 1] = 2;
                }
            }
            int len = 3;
            for (; len <= n; len++) {
                for (int i = 0; i < n; i++) {
                    int j = i + len - 1;
                    if (j >= n) {
                        break;
                    }
                    dp[i][j] = Integer.MAX_VALUE;

                    if (arr[i] == arr[j]) {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}