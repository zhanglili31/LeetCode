package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//557 反转字符串中的单词 III
//2022-06-27 12:32:44
class ReverseWordsInAStringIii {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new ReverseWordsInAStringIii().new Solution();
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
        public String reverseWords(String s) {
            List<Integer> list = new ArrayList<>();
            list.add(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    list.add(i);
                }
            }
            list.add(s.length());
            StringBuilder str = new StringBuilder(s);
            for (int i = 0; i < list.size()-1; i++) {
                int left = list.get(i) + 1, right = list.get(i + 1) - 1;
                swap(str, left, right);
            }
            return str.toString();

        }

        private void swap(StringBuilder str, int left, int right) {
            char ch;
            while (left < right) {
                ch = str.charAt(left);
                str.setCharAt(left, str.charAt(right));
                str.setCharAt(right, ch);
                left++;
                right--;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}