package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.lang.reflect.Array;
import java.util.*;

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
    //
    class WordDistance {
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();


        public WordDistance(String[] wordsDict) {
            for (int i = 0; i < wordsDict.length; i++) {
                List<Integer> temp = map.getOrDefault(wordsDict[i], new ArrayList<>());
                temp.add(i);
                map.put(wordsDict[i], temp);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> word1Points = map.get(word1);
            List<Integer> word2Points = map.get(word2);
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < word1Points.size(); i++) {
                for (int j = 0; j < word2Points.size(); j++) {
                    res = Math.min(Math.abs(word1Points.get(i) - word2Points.get(j)), res);
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