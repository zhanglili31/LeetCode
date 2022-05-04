package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//243 最短单词距离
//2022-05-05 02:24:59
class ShortestWordDistance {

    public static void main(String[] args) {
        Solution solution = new ShortestWordDistance().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //方法一：暴力方法，O(n的平方)
        public int shortestDistance0(String[] wordsDict, String word1, String word2) {
            List<Integer> word1Points = new ArrayList<>();
            List<Integer> word2Points = new ArrayList<>();
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    word1Points.add(i);
                } else if (wordsDict[i].equals(word2)) {
                    word2Points.add(i);
                }
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < word1Points.size(); i++) {
                for (int j = 0; j < word2Points.size(); j++) {
                    res = Math.min(Math.abs(word1Points.get(i) - word2Points.get(j)), res);
                }
            }
            return res;
        }

        //方法一：暴力方法，O(n的平方)
        public int shortestDistance(String[] wordsDict, String word1, String word2) {
            int points1 = Integer.MAX_VALUE, points2 = Integer.MAX_VALUE/2;
            int res = Integer.MAX_VALUE/3;
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    points1 = i;
                } else if (wordsDict[i].equals(word2)) {
                    points2 = i;
                }
                res = Math.min(Math.abs(points1-points2), res);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}