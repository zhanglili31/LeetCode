package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//434 字符串中的单词数
//2022-06-23 23:57:35
class NumberOfSegmentsInAString {

    public static void main(String[] args) {
        Solution solution = new NumberOfSegmentsInAString().new Solution();
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
        public int countSegments(String s) {
            s = s.trim();
            if (s.length() == 0) {
                return 0;
            }
            int count = 1;
            char pre = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == ' ') {
                    if (pre != ' ') {
                        count++;
                    }
                }
                pre = ch;
            }
            return count;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}