package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1258 近义词句子
//2022-06-18 15:31:42
class SynonymousSentences {

    public static void main(String[] args) {
        Solution solution = new SynonymousSentences().new Solution();
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
        class Union {
            int fa[];
            int rank[];

            public Union(int n) {
                fa = new int[n + 1];
                rank = new int[n + 1];
                for (int i = 0; i <= n; i++) {
                    fa[i] = i;
                }
            }

            int find(int x) {
                return fa[x] = fa[x] == x ? x : find(fa[x]);
            }

            void merge(int i, int j) {
                int x = find(i);
                int y = find(j);
                if (rank[x] < rank[y]) {
                    fa[x] = y;
                } else {
                    fa[y] = x;
                }
                if (rank[x] == rank[y] && x != y) {
                    rank[x]++;
                }
            }
        }

        List<String> ans = new ArrayList<>();

        public List<String> generateSentences(List<List<String>> synonyms, String text) {
            int index = 0;
            Map<String, Integer> map = new HashMap<>();
            Union union = new Union(synonyms.size() * 2);
            for (int i = 0; i < synonyms.size(); i++) {
                List<String> list = synonyms.get(i);
                if (!map.containsKey(list.get(0))) {
                    map.put(list.get(0), index++);
                }
                if (!map.containsKey(list.get(1))) {
                    map.put(list.get(1), index++);
                }
                int a = map.get(list.get(0));
                int b = map.get(list.get(1));
                union.merge(a, b);
            }
            Map<Integer, Set<String>> words = new HashMap<>();
            for (int i = 0; i < synonyms.size(); i++) {
                List<String> list = synonyms.get(i);
                String str1 = list.get(0);
                String str2 = list.get(1);
                Set<String> set = words.getOrDefault(union.find(map.get(str1)), new HashSet<String>());
                set.add(str1);
                set.add(str2);
                words.put(map.get(str1), set);
            }
            String[] ws = text.split(" ");
            DFS(words, map, union, 0, ws, "");
            ans.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            return ans;


        }

        private void DFS(Map<Integer, Set<String>> words, Map<String, Integer> map, Union union, int k, String[] text, String str) {
            if (k == text.length) {
                ans.add(str.substring(1));
                return;
            }
            Integer index = map.get(text[k]);

            if (index != null) {
                int setTag = union.find(index);
                Iterator<String> iterator = words.get(setTag).iterator();
                while (iterator.hasNext()) {
                    String next = iterator.next();
                    DFS(words, map, union, k + 1, text, str + " " + next);
                }
            } else {
                DFS(words, map, union, k + 1, text, str + " " + text[k]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}