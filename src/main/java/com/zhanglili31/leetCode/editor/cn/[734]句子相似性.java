package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//734 句子相似性
//2022-05-24 23:09:45
class SentenceSimilarity {

    public static void main(String[] args) {
        Solution solution = new SentenceSimilarity().new Solution();
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
        public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
            if (sentence1.length != sentence2.length) {
                return false;
            }
            Map<String, Set<String>> map = new HashMap<>();
            for (int i = 0; i < similarPairs.size(); i++) {
                List<String> temp = similarPairs.get(i);
                String str1 = temp.get(0);
                String str2 = temp.get(1);
                Set<String> set = map.getOrDefault(str1, new HashSet<>());
                set.add(str2);
                map.put(str1, set);
                set = map.getOrDefault(str2, new HashSet<>());
                set.add(str1);
                map.put(str2, set);
            }
            for (int i = 0; i < sentence1.length; i++) {
                boolean b1 = sentence1[i].equals(sentence2[i]);
                Set<String> set = map.get(sentence2[i]);
                boolean b2 = set != null ? set.contains(sentence1[i]) : false;
                if (!(b1 || b2)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}