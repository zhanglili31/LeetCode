package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//190 颠倒二进制位
//2022-06-17 00:39:02
class ReverseBits {

    public static void main(String[] args) {
        Solution solution = new ReverseBits().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.reverseBits(-3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            StringBuilder str = new StringBuilder(Integer.toBinaryString(n));
            int len=str.length();
            for (int i = 0; i < 32 - len; i++) {
                str.insert(0, '0');
            }
            str.reverse();
            str.insert(0, "00000000000000000000000000000000");

            return (int)Long.parseLong(str.toString(), 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}