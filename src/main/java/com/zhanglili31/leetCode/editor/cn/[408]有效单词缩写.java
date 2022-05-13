package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//408 有效单词缩写
//2022-05-13 19:24:54
class ValidWordAbbreviation {

    public static void main(String[] args) {
        Solution solution = new ValidWordAbbreviation().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.validWordAbbreviation("internationalization", "i12iz4n"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validWordAbbreviation(String word, String abbr) {
            char w;
            char a;
            int len = 0;
            int i = 0, j = 0;
            for (; i < abbr.length() && j < word.length(); i++) {
                a = abbr.charAt(i);
                if (a >= 'a') {
                    w = word.charAt(j);
                    j++;
                    if (a != w) {
                        return false;
                    }
                } else {
                    len = a - '0';
                    if (len == 0)
                        return false;
                    while (i + 1 < abbr.length() && abbr.charAt(i + 1) <= '9') {
                        len *= 10;
                        len += abbr.charAt(++i)-'0';
                    }
                    j += len;
                }

            }
            return j == word.length()&&i==abbr.length();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}