package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//剑指 Offer 20 表示数值的字符串
//2022-06-27 04:53:52
class BiaoShiShuZhiDeZiFuChuanLcof {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.isNumber(
                ".2e81"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNumber(String s) {
            s = s.trim();
            if (s.contains(".")) {
                String str[] = new String[2];
                int index = s.indexOf('.');
                str[0] = s.substring(0, index);
                str[1] = s.substring(index + 1);
                if (str[0].equals("")) {
                    return func(str[1], true);
                } else if (str[1].equals("")) {
                    return isIntegerWithSign(str[0]);
                } else {
                    if (str[0].equals("+") || str[0].equals("-")) {
                        return func(str[1], true);
                    }
                    return isIntegerWithSign(str[0]) && func(str[1], false);
                }
            }
            String e = null;
            if (s.contains("e")) {
                e = "e";
            } else if (s.contains("E")) {
                e = "E";
            }
            if (e != null) {
                int index = s.indexOf(e);
                return isIntegerWithSign(s.substring(0, index)) && isIntegerWithSign(s.substring(index + 1));
            }
            return isIntegerWithSign(s);

        }

        //可以带有符号+- 整数
        private boolean isIntegerWithSign(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            char ch = s.charAt(0);
            int i = 0;
            if (ch == '+' || ch == '-') {
                i = 1;
            }
            boolean ans = false;
            for (; i < s.length(); i++) {
                ch = s.charAt(i);
                if (ch < '0' || ch > '9') {
                    ans = false;
                    break;
                } else {
                    ans = true;
                }
            }
            return ans;


        }

        //不可以带符号
        private boolean isIntegerWithOutSign(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            char ch;

            for (int i = 0; i < s.length(); i++) {
                ch = s.charAt(i);
                if (ch < '0' || ch > '9') {
                    return false;
                }
            }
            return true;
        }

        private boolean func(String s, boolean head) {
            if (s == null || s.equals("")) {
                return false;
            }
            String e = null;
            if (s.contains("e")) {
                e = "e";
            } else if (s.contains("E")) {
                e = "E";
            }
            if (s.charAt(0) == 'e' || s.charAt(0) == 'E') {
                return isIntegerWithSign(s.substring(1)) && !head;
            } else if (e != null) {
                int index = s.indexOf(e);
                return isIntegerWithOutSign(s.substring(0, index)) && isIntegerWithSign(s.substring(index + 1));
            } else {
                return isIntegerWithOutSign(s);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}