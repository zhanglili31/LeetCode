package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//14 最长公共前缀
//2022-06-20 19:58:53
class LongestCommonPrefix {

    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
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
        public String longestCommonPrefix(String[] strs) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strs[0].length(); i++) {
                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                        return sb.toString();
                    }
                }
                sb.append(strs[0].charAt(i));
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}