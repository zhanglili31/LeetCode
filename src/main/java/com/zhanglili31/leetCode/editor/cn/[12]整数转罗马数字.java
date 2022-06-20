package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//12 整数转罗马数字
//2022-06-20 19:46:18
class IntegerToRoman {

    public static void main(String[] args) {
        Solution solution = new IntegerToRoman().new Solution();
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
        //贪心
        public String intToRoman(int num) {
            int val[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int j = 0;
            StringBuilder sb = new StringBuilder();
            while (num > 0) {
                for (int i = j; i < val.length; i++) {
                    if (num >= val[i]) {
                        num -= val[i];
                        j = i;
                        sb.append(str[i]);
                        break;
                    }
                }
            }
            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}