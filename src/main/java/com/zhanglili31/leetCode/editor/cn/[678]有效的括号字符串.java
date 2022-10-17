package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//678 有效的括号字符串
//2022-10-18 01:37:44
class ValidParenthesisString {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new ValidParenthesisString().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.checkValidString("(((((()*)(*)*))())())(()())())))((**)))))(()())()"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //方法一：动态规划 https://leetcode.cn/problems/valid-parenthesis-string/solution/you-xiao-de-gua-hao-zi-fu-chuan-by-leetc-osi3/
        public boolean checkValidString(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            int len = 1;

            // 初始化 len=1 len=2;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '*') {
                    dp[i][i] = true;
                }
            }
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) == '*' && s.charAt(i + 1) == '*' ||
                        s.charAt(i) == '(' && s.charAt(i + 1) == ')' ||
                        s.charAt(i) == '*' && s.charAt(i + 1) == ')' ||
                        s.charAt(i) == '(' && s.charAt(i + 1) == '*'
                ) {
                    dp[i][i + 1] = true;
                }
            }
            //len>2
            for (len = 3; len <= n; len++) {
                for (int i = 0; i <= n - len; i++) {
                    int j = i + len - 1;
                    if (dp[i + 1][j - 1] && ((s.charAt(i) == '*' || s.charAt(i) == '(') && (s.charAt(j) == ')' || s.charAt(j) == '*'))) {
                        dp[i][j] = true;
                    }else{
                        for (int k = i; k < j && !dp[i][j]; k++) {
                            if (dp[i][k] && dp[k + 1][j]) {
                                dp[i][j] = true;
                            }
                        }
                    }



                }
            }
            return dp[0][n - 1];
        }
        //todo 方法二栈和方法三贪心
    }
//leetcode submit region end(Prohibit modification and deletion)

}