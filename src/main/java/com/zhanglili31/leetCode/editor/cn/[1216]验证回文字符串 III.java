package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1216 验证回文字符串 III
//2022-06-16 15:07:18
class ValidPalindromeIii {

    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIii().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.isValidPalindrome("abbababa", 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidPalindrome(String s, int k) {
            if (s.length() < 2) {
                return true;
            }
            int n = s.length();
            int minLen = 1;
            int dp[][] = new int[n][n];
            int len = 2;
            for (; len <= n; len++) {
                for (int i = 0; i < n; i++) {
                    int j = i + len - 1;
                    if (j >= n) {
                        break;
                    }
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - 1 == i) {
                            dp[i][j] = 0;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    } else {
                        if (j - 1 == i) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = Math.min(Math.min(dp[i + 1][j - 1] + 2, dp[i][j - 1] + 1), dp[i + 1][j] + 1);
                        }
                    }
                    //n=7,k=2 ,存在一个真实长度为5的回文串，那么就是满足条件的。
                    //真实长度的计算就是：长度-需要减去的字符个数。
                    if (len - dp[i][j] >= n - k) {
                        System.out.println(s.substring(i, j + 1));
                        return true;
                    }
                }
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}