package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//面试题 01.06 字符串压缩
//2022-06-18 22:33:44
class CompressStringLcci {

    public static void main(String[] args) {
        Solution solution = new CompressStringLcci().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.compressString("aabcccccaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String compressString(String S) {
            if (S == null || S.length() == 0) {
                return S;
            }
            StringBuilder str = new StringBuilder();
            int init = 1;
            int n = S.length();
            for (int i = 1; i < S.length(); i++) {
                if (S.charAt(i - 1) == S.charAt(i)) {
                    init++;
                } else {
                    str.append(""+S.charAt(i - 1) + init);
                    init = 1;
                }
            }

            str.append(""+S.charAt(n - 1) + init);
            if (str.length() < S.length()) {
                return str.toString();
            } else {
                return S;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}