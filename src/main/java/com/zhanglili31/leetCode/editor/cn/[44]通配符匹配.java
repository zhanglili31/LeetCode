package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//44 通配符匹配
//2022-06-23 22:15:57
class WildcardMatching {

    public static void main(String[] args) {
        Solution solution = new WildcardMatching().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.isMatch("aa", "*aa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            p = " " + p;
            s = " " + s;

            int dp[][] = new int[p.length()][s.length()];
            dp[0][0] = 1;
            for (int i = 1; i < p.length(); i++) {
                if (p.charAt(i) == '*'&&dp[i-1][0]==1) {
                    dp[i][0] = 1;
                }
            }

            for (int i = 1; i < p.length(); i++) {
                char pch = p.charAt(i);
                for (int j = 1; j < s.length(); j++) {
                    char sch = s.charAt(j);
                    if (pch == '*') {
                        if (dp[i - 1][j - 1] == 1 || dp[i - 1][j] == 1 || dp[i][j - 1] == 1) {
                            dp[i][j] = 1;
                        }

                    } else if (pch == '?') {
                        if (dp[i - 1][j - 1] == 1) {
                            dp[i][j] = 1;
                        }
                    } else {//pch 是字符
                        if (pch == sch) {
                            if (dp[i - 1][j - 1] == 1) {
                                dp[i][j] = 1;
                            }
                        }
                    }
                }
            }
            return dp[p.length() - 1][s.length() - 1] == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}