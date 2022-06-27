package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//剑指 Offer 19 正则表达式匹配
//2022-06-27 02:24:38
class ZhengZeBiaoDaShiPiPeiLcof {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new ZhengZeBiaoDaShiPiPeiLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.isMatch("aa", "a*"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            s = " " + s;
            p = " " + p;
            int m = p.length();
            int n = s.length();
            int dp[][] = new int[m][n];
            dp[0][0] = 1;
            char ch[] = new char[2];
            for (int i = 0; i < m; i++) {
                if (i + 1 < m && p.charAt(i + 1) == '*') {
                    ch[0] = p.charAt(i);
                    ch[1] = '*';
                    i++;
                } else {
                    ch[0] = p.charAt(i);
                    ch[1] = ' ';
                }
                for (int j = 0; j < n; j++) {
                    if (ch[1] == '*') {//匹配1次  aa  aa*  =>
                        if ((ch[0] == s.charAt(j) || ch[0] == '.') && (i - 2 >= 0 && j - 1 >= 0 && dp[i - 2][j - 1] == 1)) {
                            dp[i][j] = 1;
                            //匹配0次 c ca*
                        } else if (i - 2 >= 0 && dp[i - 2][j] == 1) {
                            dp[i][j] = 1;
                            //匹配多次 aaa aa* || aa aa*(a*)
                        } else if ((ch[0] == s.charAt(j) || ch[0] == '.') && (j - 1 >= 0 && dp[i][j - 1] == 1)) {
                            dp[i][j] = 1;
                        }
                    } else if (ch[0] == s.charAt(j) || ch[0] == '.') {
                        if (i - 1 >= 0 && j - 1 >= 0 && dp[i - 1][j - 1] == 1) {
                            dp[i][j] = 1;
                        }
                    }


                }
            }
            return dp[m - 1][n - 1] == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}