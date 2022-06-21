package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//91 解码方法
//2022-06-21 22:47:41
class DecodeWays {

    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.numDecodings("111111111111111111111111111111111111111111111"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //回溯法：超时
        //1836311903 "111111111111111111111111111111111111111111111"
        public int numDecodings2(String s) {
            if (s == null || s.length() > 0 && s.charAt(0) == '0') {
                return 0;
            }
            if (s.length() == 1 || s.equals("")) {
                return 1;
            }
            String str = s.substring(0, 2);
            int v = Integer.parseInt(str);
            if (v == 10 || v == 20) {
                return numDecodings2(s.substring(2));
            }
            if (v >= 11 && v <= 26) {
                return numDecodings2(s.substring(2)) + numDecodings2(s.substring(1));
            }
            return numDecodings2(s.substring(1));
        }

        //动态规划fn=fn-2+fn-1;
        public int numDecodings(String s) {
            if (s == null || s.length() > 0 && s.charAt(0) == '0') {
                return 0;
            }
            int dp[] = new int[s.length() + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 1; i < s.length(); i++) {
                int v = Integer.parseInt(s.substring(i - 1, i + 1));
                if (v == 0 || s.charAt(i) == '0' && v / 10 > 2) {
                    return 0;
                }
                if (v == 10 || v == 20) {
                    dp[i + 1] = dp[i - 1];
                } else if (v >= 11 && v <= 26) {
                    dp[i + 1] = dp[i] + dp[i - 1];
                } else if (v > 26 || v < 10) {
                    dp[i + 1] = dp[i];
                }

            }
            return dp[s.length()];

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}