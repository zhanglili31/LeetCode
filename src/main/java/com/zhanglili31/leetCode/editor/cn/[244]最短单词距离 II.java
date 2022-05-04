package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//244 最短单词距离 II
//2022-05-05 02:58:00
class ShortestWordDistanceIi {

    public static void main(String[] args) {
//        Solution solution = new ShortestWordDistanceIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //todo 244 fuck 提交没有通过，需要找出超时的原因。
    class WordDistance {
        String wordsDict[] = null;

        public WordDistance(String[] wordsDict) {
            this.wordsDict = wordsDict;

        }

        public int shortest(String word1, String word2) {
            int points1 = Integer.MAX_VALUE, points2 = Integer.MAX_VALUE / 2;
            int res = Integer.MAX_VALUE / 3;
            System.out.println(word1 + " " + word2);
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    points1 = i;
                    res = Math.min(Math.abs(points1 - points2), res);
                } else if (wordsDict[i].equals(word2)) {
                    points2 = i;
                    res = Math.min(Math.abs(points1 - points2), res);
                }
                if (res == 1) {
                    return res;
                }

            }
            return res;
        }
    }

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}