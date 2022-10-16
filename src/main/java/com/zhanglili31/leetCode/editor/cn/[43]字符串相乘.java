package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//43 字符串相乘
//2022-10-16 04:13:11
class MultiplyStrings {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new MultiplyStrings().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.multiply("1", "1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            List<StringBuilder> tempResult = new ArrayList<StringBuilder>();
            for (int i = num1.length() - 1; i >= 0; i--) {
                tempResult.add(mul(num1.charAt(i), num2, num1.length() - i - 1));
            }
            StringBuilder res = tempResult.get(0);
            for (int i = 1; i < tempResult.size(); i++) {
                res = StringPlus(res, tempResult.get(i));
            }
            while (res.length() > 1 && res.charAt(res.length() - 1) == '0') {
                res.setLength(res.length() - 1);
            }
            res.reverse();
            return res.toString();
        }

        private StringBuilder mul(char ch, String str, int zeroNum) {
            StringBuilder strb = new StringBuilder();
            int flag = 0;
            int n = ch - '0';
            int v = 0;
            int res = 0;
            for (int i = 0; i < zeroNum; i++) {
                strb.append("0");
            }
            for (int i = str.length() - 1; i >= 0; i--) {
                v = str.charAt(i) - '0';
                res = v * n + flag;
                flag = res / 10;
                res = res % 10;
                strb.append(res + "");
            }
            if (flag != 0) {
                strb.append(flag + "");
            }
            return strb;
        }

        private StringBuilder StringPlus(StringBuilder str1, StringBuilder str2) {
            int maxLen = Math.max(str1.length(), str2.length()) + 1;
            int d1 = maxLen - str1.length();
            int d2 = maxLen - str2.length();

            for (int i = 0; i < d1; i++) {
                str1.append("0");
            }
            for (int i = 0; i < d2; i++) {
                str2.append("0");
            }
            StringBuilder sb3 = new StringBuilder();
            int flag = 0;
            int res = 0;
            for (int i = 0; i < str1.length(); i++) {
                res = str1.charAt(i) + str2.charAt(i) + flag - 2 * '0';
                flag = res / 10;
                res = res % 10;
                sb3.append(res + "");
            }
            return sb3;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}