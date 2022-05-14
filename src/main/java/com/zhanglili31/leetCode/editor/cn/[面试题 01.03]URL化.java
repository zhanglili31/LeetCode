package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//面试题 01.03 URL化
//2022-05-14 21:33:33
class StringToUrlLcci {

    public static void main(String[] args) {
        Solution solution = new StringToUrlLcci().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpaces(String S, int length) {
            StringBuilder strb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                if (S.charAt(i) == ' ') {
                    strb.append("%20");
                } else {
                    strb.append(S.charAt(i));
                }
            }
            return strb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}