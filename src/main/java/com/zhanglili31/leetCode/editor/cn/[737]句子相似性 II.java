package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//737 句子相似性 II
//2022-05-24 23:35:31
class SentenceSimilarityIi {

    public static void main(String[] args) {
        Solution solution = new SentenceSimilarityIi().new Solution();
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
        class Union {
            int fa[];
            int rank[];

            Union(int num) {
                fa = new int[num + 1];
                rank = new int[num + 1];
                for (int i = 0; i <= num; i++) {
                    fa[i] = i;
                }
            }

            int find(int i) {
                return fa[i] = fa[i] == i ? i : find(fa[i]);
            }
            void merge(int i,int j) {
                int x = find(i);
                int y = find(j);
                if (rank[x] <= rank[y]) {
                    fa[x] = y;
                }else{
                    fa[y] = x;//rank[x]>rank[y] 这种情况rank不需要增加。x为头
                }
                if (rank[x] == rank[y] && x != y) {
                    rank[y]++;
                }
            }

        }

        public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
            if (sentence1.length != sentence2.length) {
                return false;
            }
            Map<String, Integer> map = new HashMap<>();
            List<String>temp=null;
            String str1=null;
            String str2=null;
            Union union = new Union(similarPairs.size() * 2);
            for (int i = 0; i < similarPairs.size(); i++) {
                temp = similarPairs.get(i);
                str1 = temp.get(0);
                str2 = temp.get(1);
                map.put(str1, map.getOrDefault(str1, map.size()));
                map.put(str2, map.getOrDefault(str2, map.size()));
                union.merge(map.get(str1), map.get(str2));
            }
            for (int i = 0; i < sentence1.length; i++) {
                boolean b1 = sentence1[i].equals(sentence2[i]);
                Integer i1 = map.get(sentence1[i]);
                Integer i2 = map.get(sentence2[i]);
                boolean b2=false;
                if (i1 == null || i2 == null) {
                    b2=false;
                }else{
                    b2 = union.find(i1) == union.find(i2);
                }
                if (b1 || b2) {
                    continue;
                }else{
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}