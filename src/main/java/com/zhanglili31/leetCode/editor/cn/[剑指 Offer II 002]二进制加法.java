package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//剑指 Offer II 002 二进制加法
//2022-06-25 08:38:21
class JFETK5 {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new JFETK5().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.addBinary("11", "0111111"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            if (a.length() > b.length()) {
                String temp = a;
                a = b;
                b = temp;
            }
            int n = b.length() - a.length();
            for (int i = 0; i < n; i++) {
                a = "0" + a;
            }
            a = "0" + a;
            b = "0" + b;

            int x = 0, y = 0, t = 0;
            StringBuilder str = new StringBuilder();
            for (int i = a.length() - 1; i >= 0; i--) {
                x = a.charAt(i) - '0';
                y = b.charAt(i) - '0';
                int res = x ^ y ^ t;
                t = (x + y + t) / 2;
                str.append(res + "");
            }
            str.reverse();
            String ans = b.substring(0, b.length() - a.length()) + str.toString();
            if (ans.charAt(0) == '0') {
                ans = ans.substring(1);
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}