package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//395 至少有 K 个重复字符的最长子串
//2022-06-22 23:36:30
class LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.longestSubstring("bbaaacbd", 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //方法一：通过记录前缀和的方式，将题目转变成滑动窗口的解决方式
        public int longestSubstring(String s, int k) {
            int dp[][] = new int[s.length() + 1][26];
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    dp[i + 1][j] = dp[i][j];
                }
                dp[i + 1][s.charAt(i) - 'a']++;
            }
            for (int len = s.length(); len >= k; len--) {
                for (int right = s.length(); right - len >= 0; right--) {
                    int left = right - len;
                    boolean flag = true;
                    for (int i = 0; i < 26; i++) {
                        int v = dp[right][i] - dp[left][i];
                        if (dp[right][i] == 0 || v == 0) {
                            continue;
                        } else if (v < k) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return len;
                    }
                }
            }
            return 0;

        }
        //todo 方法二：二分：思路参见：https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/solution/zhi-shao-you-kge-zhong-fu-zi-fu-de-zui-c-o6ww/
        //有时间可以再用这种方式做一遍
    }
//leetcode submit region end(Prohibit modification and deletion)

}