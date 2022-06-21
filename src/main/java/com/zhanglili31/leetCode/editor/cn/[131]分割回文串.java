package com.zhanglili31.leetCode.editor.cn;

import java.util.*;

//131分割回文串
//2021-03-07 06:22:57
class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        System.out.println(solution.partition("acab"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            int n = s.length();
            boolean dp[][] = new boolean[n][n];
            for (int len = 1; len <= s.length(); len++) {
                for (int i = 0; i < s.length(); i++) {
                    int j = i + len - 1;
                    if (j<s.length()&&s.charAt(i) == s.charAt(j)) {
                        if (i == j || j - 1 == i || dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                        }
                    }

                }
            }

            return DFS(dp, s, 0);
        }

        List<List<String>> DFS(boolean[][] dp, String s, int i) {
            List<List<String>> list = new LinkedList<>();
            if (i == s.length()) {
                return list;
            }
            for (int j = i; j < s.length(); j++) {
                if (dp[i][j]) {
                    String str = s.substring(i, j + 1);
                    List<List<String>> child = DFS(dp, s, j + 1);
                    if (child.size() > 0) {
                        for (int k = 0; k < child.size(); k++) {
                            List<String> temp = child.get(k);
                            temp.add(0, str);
                            list.add(temp);
                        }
                    } else {
                        List<String> temp = new LinkedList<String>();
                        temp.add(str);
                        list.add(temp);
                    }
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}