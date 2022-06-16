package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//5最长回文子串
//2021-04-13 00:28:10
class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        TreeNode r = CreateTree.deserialize("[5,4,2,3,3,7]");
        System.out.println(solution.longestPalindrome("abcdeca"));

   }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //暴力解法
        public String longestPalindrome2(String s) {
            String pre = null;
            String pro = null;
            int h = 0, t = 0;
            String res = null;
            int len = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j < s.length() + 1; j++) {
                    String temp = s.substring(i, j);
                    if (isConvert(temp)) {
                        if (len < temp.length()) {
                            res = temp;
                            len = temp.length();
                        }
                    }
                }
            }
            return res;
        }

        private boolean isConvert(String s) {
            if (s == null || "".equals(s))
                return false;
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }

        //动态规划的算法： 思路：如果s(i,j)是一个会回文串，s(i-1)==s(j+1),那么是s(i-1,j+1)也是一个回文串；
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n < 2) {
                return s;
            }
            String ans = s.substring(0,1);
            boolean dp[][] = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }
            int Len = 2;
            for (; Len <= n; Len++) {
                for (int i = 0; i < n; i++) {
                    int j = i + Len - 1;
                    if (j >= n) {
                        break;
                    }
                    if (s.charAt(i) == s.charAt(j) && (j - 1 < i + 1 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        if (ans.length() < j - i + 1) {
                            ans = s.substring(i, j + 1);
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
