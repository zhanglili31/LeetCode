package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//6 Z 字形变换
//2022-06-27 03:24:20
class ZigzagConversion {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new ZigzagConversion().new Solution();
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
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            StringBuilder str[] = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                str[i] = new StringBuilder();
            }
            int i = 0;
            int index = 0;
            int factor = 1;
            while (i < s.length()) {
                str[index].append(s.charAt(i));
                index += factor;
                i++;
                if (index < 0) {
                    index = 1;
                    factor = 1;
                }
                if (index >= numRows) {
                    index = numRows - 2;
                    factor = -1;
                }
            }
            String ans = "";
            for (i = 0; i < numRows; i++) {
                ans += str[i];
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}