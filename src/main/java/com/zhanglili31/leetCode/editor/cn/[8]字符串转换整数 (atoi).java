package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//8 字符串转换整数 (atoi)
//2022-06-20 15:53:42
class StringToIntegerAtoi {

    public static void main(String[] args) {
        Solution solution = new StringToIntegerAtoi().new Solution();
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
        public int myAtoi(String s) {
            long ans = 0;
            int sign = 1;
            s = s.trim();
            for (int i = 0; i < s.length(); i++) {
                if (i == 0 && s.charAt(0) == '-') {
                    sign = -1;
                } else if (i == 0 && s.charAt(0) == '+') {
                    sign = 1;
                } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    ans *= 10;
                    ans += s.charAt(i) - '0';
                    if (sign == 1 && ans >= Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    } else if (sign == -1 && -1 * ans <= Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    break;
                }
            }
            return (int) ans * sign;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}