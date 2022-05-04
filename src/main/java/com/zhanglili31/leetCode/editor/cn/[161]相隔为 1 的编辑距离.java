package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//161 相隔为 1 的编辑距离
//2022-05-04 09:33:47
class OneEditDistance {

    public static void main(String[] args) {
        Solution solution = new OneEditDistance().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.isOneEditDistance("", ""));
    }


    class Solution {
        public boolean isOneEditDistance(String s, String t) {
            if (Math.abs(s.length() - t.length()) > 1)
                return false;
            char sch = '0';
            char tch = '0';

            if (s.length() - t.length() == 0) {
                for (int i = 0; i < t.length(); i++) {
                    sch = s.charAt(i);
                    tch = t.charAt(i);
                    StringBuilder strReplace = new StringBuilder(s);
                    if (sch != tch) {
                        strReplace.replace(i, i + 1, String.valueOf(tch));
                        return t.equals(strReplace.toString());

                    }
                }
                return false;
            }

            if (s.length() < t.length()) {
                String temp = s;
                s = t;
                t = temp;
            }
            for (int i = 0; i < s.length(); i++) {
                StringBuilder strDel = new StringBuilder(s);
                if (i < t.length()) {
                    sch = s.charAt(i);
                    tch = t.charAt(i);
                }
                if (sch != tch || i >= t.length()) {
                    strDel.deleteCharAt(i);
                    return t.equals(strDel.toString());
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}