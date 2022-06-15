package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//剑指 Offer 58 - II 左旋转字符串
//2022-06-15 22:03:38
class ZuoXuanZhuanZiFuChuanLcof {

    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
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
        public String reverseLeftWords(String s, int n) {
            if (n >= s.length()) {
                return s;
            }
            StringBuilder str = new StringBuilder();
            for (int i = n; i < s.length(); i++) {
                str.append(s.charAt(i));
            }
            for (int i = 0; i < n; i++) {
                str.append(s.charAt(i));
            }
            return str.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}