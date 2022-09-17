package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//415 字符串相加
//2022-09-17 07:11:42
class AddStrings {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new AddStrings().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            num1 = "0" + num1;
            num2 = "0" + num2;
            int d = Math.abs(num1.length() - num2.length());
            StringBuilder zero = new StringBuilder();
            for (int i = 0; i < d; i++) {
                zero.append('0');
            }
            if (num1.length() > num2.length()) {
                num2 = zero.toString() + num2;
            } else {
                num1 = zero.toString() + num1;
            }
            int b = 0;
            StringBuilder sb = new StringBuilder();
            for (int k = num1.length() - 1; k >= 0; k--) {
                int v = num1.charAt(k) + num2.charAt(k) - '0' * 2 + b;
                b = 0;
                if (v > 9) {
                    b = 1;
                    v = v - 10;
                }
                sb.append("" + v);
            }
            sb.reverse();
            String res = null;
            if (sb.charAt(0) == '0') {
                res = sb.substring(1);
            } else {
                res = sb.substring(0);
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}