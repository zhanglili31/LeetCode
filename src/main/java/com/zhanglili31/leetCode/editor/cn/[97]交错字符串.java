package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//97 交错字符串
//2022-10-20 01:29:36
class InterleavingString {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new InterleavingString().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isInterleave(String s1, String s2, String s3) {
            //方法一：递归，
//            return recursion(s1, s2, s3);
            //方法二
            return dynamicProgramming(s1, s2, s3);

        }

        //方法一：递归--超时
        private boolean recursion(String s1, String s2, String s3) {

            if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
                return true;
            }
            boolean r1 = false, r2 = false;
            if (s1.length() > 0 && s1.charAt(0) == s3.charAt(0)) {
                r1 = isInterleave(s1.substring(1), s2, s3.substring(1));
            }
            if (s2.length() > 0 && s2.charAt(0) == s3.charAt(0)) {
                r2 = isInterleave(s1, s2.substring(1), s3.substring(1));
            }
            return r2 || r1;
        }

        //方法二：动态规划
        private boolean dynamicProgramming(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            int m = s1.length();
            int n = s2.length();
            boolean dp[][] = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                    if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] |= dp[i][j - 1];
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}