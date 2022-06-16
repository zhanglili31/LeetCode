package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//13 罗马数字转整数
//2022-06-16 23:59:26
class RomanToInteger {

    public static void main(String[] args) {
        Solution solution = new RomanToInteger().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
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
        public int romanToInt(String s) {
            int a[] = new int[26];
            a['I' - 'A'] = 1;
            a['V' - 'A'] = 5;
            a['X' - 'A'] = 10;
            a['L' - 'A'] = 50;
            a['C' - 'A'] = 100;
            a['D' - 'A'] = 500;
            a['M' - 'A'] = 1000;
            int sum = 0;
            if (s == null || s.length() < 0) {
                return 0;
            }
            if (s.length() == 1) {
                return a[s.charAt(0) - 'A'];
            }
            int n = s.length();
            char pre = s.charAt(n - 1);
            sum += a[pre - 'A'];
            for (int i = n - 2; i >= 0; i--) {
                char ch = s.charAt(i);
                if (a[ch - 'A'] < a[pre - 'A']) {
                    sum -= a[ch - 'A'];
                } else {
                    sum += a[ch - 'A'];
                }
                pre = ch;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}