package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//544 输出比赛匹配对
//2022-05-18 15:06:11
class OutputContestMatches {

    public static void main(String[] args) {
        Solution solution = new OutputContestMatches().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.findContestMatch(16));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findContestMatch(int n) {
            //1～n 初始化
            String[] pairs = new String[n];
            for (int i = 1; i <= n; i++) {
                pairs[i] = i + "";
            }
            //每经过一轮比赛，递归一次
            return recursion(pairs);
        }

        public String recursion(String[] pair) {

            if (pair.length == 1) {
                return pair[0];
            }
            int i = 0, j = pair.length - 1;
            String temp[] = new String[pair.length >> 1];
            while (i < j) {
                temp[i] = pair(pair[i], pair[j]);
                i++;
                j--;
            }
            return recursion(temp);
        }

        public String pair(String str1, String str2) {
            return "(" + str1 + "," + str2 + ")";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}