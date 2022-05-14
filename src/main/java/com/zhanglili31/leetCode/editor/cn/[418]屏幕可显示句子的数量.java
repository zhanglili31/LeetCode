package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//418 屏幕可显示句子的数量
//2022-05-14 20:41:54
class SentenceScreenFitting {

    public static void main(String[] args) {
        Solution solution = new SentenceScreenFitting().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"tpgl", "brqe", "wvvquojeh", "vehbhsj", "nicowu", "fejqky", "elg", "vwpbsm", "wsmplm", "tijf", "gtuujjesu", "zatkqbmeq", "qerucwer", "pevdflxvo", "ndagbkbqft", "gbm", "dqnunyiw", "qa", "yhumy", "qh", "nfprt", "dpj", "bkctxwbbgc", "mbqqnkyi", "kdn", "mzunp", "xrgegcu", "vxfxmmqf", "ruqwclx", "bbauvgyaru", "djpyxbbt", "vmgeld", "mwvvspgklq", "tmqtq", "nubymta", "qqzeqg", "wh", "tul", "imawmqasy", "ovxoihtuz", "c", "tvlrtkk", "g", "mnqp", "fscwh", "ou", "oq", "vnghd", "zptoo", "cl", "huhjecx", "iurshssq", "fijpr", "xmusn", "stscdep", "xoyywgn", "sxvgynnb", "b", "lnlueyomlg", "f", "j", "exn", "wltqouopqv", "ulo", "v", "ud", "vucvtms", "hzkbswn", "ix", "tovtl", "lbrqmx", "vg", "m", "hynilg", "juqa", "gxrjmxzbc", "pcydkl", "vqsinyfb", "lxcg", "kjulwo", "pwfpjtiw", "cefvbkogi", "rjxvcximeo", "xxgx", "osda", "ocvw", "aydcul", "xmgva", "heiuq", "a", "rlbncaa", "kf", "i", "uwyajpdeb", "yqnis", "glrhniazyf", "ixslvy", "neaqh", "psxpdzrq", "y"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.wordsTyping(strArray, 20000, 20000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int wordsTyping(String[] sentence, int rows, int cols) {
            int n = sentence.length;
            int i = 0;
            int rowIndex = 0;
            int colsLeft = cols;
            int ans = 0;
            while (rowIndex < rows) {
                int len = sentence[i].length();
                if (colsLeft >= len) {
                    colsLeft -= len;
                    i++;
                    if (i == n) {
                        ans++;
                        i = 0;
                    }
                    if (colsLeft == 0) {
                        rowIndex += 1;
                        colsLeft = cols;
                    } else {
                        colsLeft -= 1;
                    }
                } else {
                    rowIndex += 1;
                    colsLeft = cols;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}