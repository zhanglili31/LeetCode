package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1062 最长重复子串
//2022-06-04 05:05:43
class LongestRepeatingSubstring {

    public static void main(String[] args) {
        Solution solution = new LongestRepeatingSubstring().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "aabcaabdaab";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.longestRepeatingSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //动态规划2
        public int longestRepeatingSubstring(String s) {
            int n = s.length();
            int dp[][] = new int[n][n];
            int ans=0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (i != 0) {
                            dp[i][j] = dp[i - 1][j - 1] + 1;
                        } else {
                            dp[i][j] = 1;
                        }
                        ans = Math.max(dp[i][j], ans);
                    }
                }
            }
            return ans;
        }

        //动态规划 dp[i][j]=dp[i][j-1]+
        public int longestRepeatingSubstring3(String s) {
            int n = s.length();
//            List<Integer> dp[][] = new List[n][n];
            int ans = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    char ch = s.charAt(j);
                    if (j - i == 0) {
                        list.clear();
                        for (int k = 0; k < n; k++) {
                            if (k == i) {
                                continue;
                            }
                            if (ch == s.charAt(k)) {
                                list.add(k);
                                ans = Math.max(ans, 1);
                            }
                        }
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        for (int k = 0; k < list.size(); k++) {
                            int init = list.get(k);
                            int target = init + j - i;
                            if (target == j || target >= n) {
                                continue;
                            } else if (s.charAt(target) == ch) {
                                ans = Math.max(ans, j - i + 1);
                                temp.add(init);
                            }
                        }
                        list = temp;
                    }

                }
            }
            return ans;
        }

        //暴力解法，从最长的字串开始挨个查找，超时
        public int longestRepeatingSubstring2(String s) {
            int ans = s.length() - 1;
            while (ans > 0) {
                for (int j = 0; j + ans < s.length(); j++) {
                    String repeat = s.substring(j, ans + j);
                    for (int i = 0; i < s.length(); i++) {
                        if (i == j) {
                            continue;
                        }
                        if (s.startsWith(repeat, i)) {
                            return ans;
                        }
                    }
                }
                ans--;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}