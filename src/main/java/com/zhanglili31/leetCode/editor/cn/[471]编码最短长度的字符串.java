package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//471 编码最短长度的字符串
//2022-05-18 13:04:04
class EncodeStringWithShortestLength {

    public static void main(String[] args) {
        Solution solution = new EncodeStringWithShortestLength().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.encode("aaaaaaaaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //推荐使用回溯，暴力搜索。所有的连续相同字串。
        //https://www.zhihu.com/zvideo/1479606535223091200
        public String encode(String s) {
            int n = s.length();
            String dp[][] = new String[n][n];
            for (int len = 0; len < s.length(); len++) {
                for (int i = 0; i < n - len; i++) {
                    int j = i + len;
                    String sub = s.substring(i, j+1);
                    dp[i][j] = sub;
                    if (j - i < 4) {
                        dp[i][j] = sub;
                    }else{
                        for (int k = i; k < j; k++) {
                            if ((dp[i][k] + dp[k + 1][j]).length() < dp[i][j].length()) {
                                dp[i][j] = dp[i][k] + dp[k + 1][j];
                            }
                        }
                        for (int k = 0; k <sub.length(); k++) {
                            String repeatString = sub.substring(0, k+1);
                            if (sub.length() % repeatString.length() == 0 && sub.replaceAll(repeatString, "").length() == 0) {
                                String addStr = String.valueOf(sub.length() / repeatString.length()) + "[" + dp[i][i + k] + "]";
                                if (dp[i][j].length() > addStr.length()) {
                                    dp[i][j] = addStr;
                                }
                            }
                        }
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}