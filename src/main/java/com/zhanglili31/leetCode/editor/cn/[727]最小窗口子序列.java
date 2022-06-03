package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//727 最小窗口子序列
//2022-06-02 23:47:04
class MinimumWindowSubsequence {

    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubsequence().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "abcdebdde";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.minWindow(testStr, "bde"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //解题思路：滑动窗口
        public String minWindow(String s1, String s2) {
            String ans = "";
            int w0 = 0;
            int i = 0, j = 0;
            int s2Index = 0;
            while (j < s1.length()) {
                while (j < s1.length() && s2Index < s2.length()) {
                    // 窗口右滑动扩张
                    if (s1.charAt(j) == s2.charAt(s2Index)) {
                        s2Index++;
                    }
                    j++;
                }
                String temp = s1.substring(i, j);
                //窗口向左滑动减小
                while (i <= j && s2Index == s2.length()) {
                    if (ans.equals("") || ans.length() > j - i ) {
                        ans = s1.substring(i, j );
                    }
                    if (s1.charAt(i) == s2.charAt(0)) {
                        j = i + 1;
                        s2Index = 0;
                    }
                    i++;
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}