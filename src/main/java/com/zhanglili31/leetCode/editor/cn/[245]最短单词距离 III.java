package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.*;

//245 最短单词距离 III
//2022-05-05 04:00:19
class ShortestWordDistanceIii {

    public static void main(String[] args) {
        Solution solution = new ShortestWordDistanceIii().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //讲解的非常清晰 ：https://github.com/jyj407/leetcode/blob/master/243.md
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int points1 = Integer.MAX_VALUE, points2 = Integer.MAX_VALUE/2;
        int res = Integer.MAX_VALUE/3;
        if (word1.equals((word2))) {
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    res = Math.min(Math.abs(points1-i), res);
                    points1 = i;
                }
            }
            return res;
        }
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