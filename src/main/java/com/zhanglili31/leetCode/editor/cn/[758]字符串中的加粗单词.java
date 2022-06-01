package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//758 字符串中的加粗单词
//2022-06-01 06:27:41
class BoldWordsInString {

    public static void main(String[] args) {
        Solution solution = new BoldWordsInString().new Solution();
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
        public String boldWords(String[] words, String s) {
            int mask[] = new int[s.length()];
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < s.length(); j++) {
                    if (s.startsWith(words[i], j)) {
                        for (int k = j; k < j + words[i].length(); k++) {
                            mask[k] = 1;
                        }
                    }
                }
            }
            String pre = "<b>";
            String pro = "</b>";
            StringBuilder str = new StringBuilder();
            int j = 0;
            for (int i = 0; i < mask.length; i++) {
                if (i == 0 && mask[i] == 1) {
                    str.append(pre);
                } else if (i - 1 >= 0 && mask[i - 1] == 0 && mask[i] == 1) {
                    str.append(pre);
                }
                str.append(s.charAt(j));
                if (i == mask.length - 1 && mask[i] == 1) {
                    str.append(pro);
                } else if (i + 1 < mask.length && mask[i] == 1 && mask[i + 1] == 0) {
                    str.append(pro);
                }
                j++;
            }
            return str.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}