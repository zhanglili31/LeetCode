package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

// todo 整理下思路，再做一遍
//10 正则表达式匹配
//2022-04-20 02:15:10
class RegularExpressionMatching {

    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.isMatch("ab", ".*a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //Not AC
        public boolean isMatch(String s, String p) {

            int dp[][] = new int[p.length() + 1][s.length() + 1];
            for (int i = 1; i <= p.length(); i++) {
                char pch = p.charAt(i - 1);
                for (int j = 1; j <= s.length(); j++) {
                    char sch = s.charAt(j - 1);
                    if (pch == '*' || pch == '.' || pch == sch) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;

                    }
                    if (dp[i][j] == s.length()) {
                        return true;
                    }
                }
            }
            return false;
        }

        //AC
        public boolean isMatch2(String s, String p) {
            boolean res = false;
            int sLength = s.length();
            int pLength = p.length();
            int[][] dp = new int[pLength + 1][sLength + 1];
            dp[0][0] = 1;
            char charP = 0;
            char charS = 0;
            for (int i = 1; i < pLength + 1; i++) {
                charP = p.charAt(i - 1);
                if (charP == '*' && i - 2 >= 0 && dp[i - 2][0] == 1) {
                    dp[i][0] = 1;
                }
            }
            for (int col = 1; col < sLength + 1; col++) {
                charS = s.charAt(col - 1);
                for (int row = 1; row < pLength + 1; row++) {
                    charP = p.charAt(row - 1);
                    switch (charP) {
                        case '*': {
                            if (row - 2 >= 0 && dp[row - 2][col] == 1 || row - 1 >= 0 && dp[row - 1][col] == 1 || dp[row][col - 1] == 1 && (p.charAt(row - 2) == charS || p.charAt(row - 2) == '.')) {
                                dp[row][col] = 1;
                            }
                        }
                        break;
                        case '.': {
                            if (dp[row - 1][col - 1] == 1) {
                                dp[row][col] = 1;
                            }
                        }
                        break;
                        default: {
                            if (charP == charS && dp[row - 1][col - 1] == 1) {
                                dp[row][col] = 1;
                            }
                        }
                    }
                }
            }
            return dp[pLength][sLength] == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}