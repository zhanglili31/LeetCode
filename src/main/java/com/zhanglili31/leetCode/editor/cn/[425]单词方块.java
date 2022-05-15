package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//425 单词方块
//2022-05-15 14:01:32
class WordSquares {

    public static void main(String[] args) {
        Solution solution = new WordSquares().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"area","lead","wall","lady","ball"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.wordSquares(strArray));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> wordSquares(String[] words) {
            List<List<String>> ans = new ArrayList<>();
            if (words == null)
                return null;
            int n = words[0].length();
            int row = 0;
            int[] points = new int[n];
            List<String> list = new ArrayList<>();
            Map<String, List<String>> map = createMap(words);
            //从第一行开始的第0个开始，知道第一行的最后一个访问完，points[0]>=length,回溯完成。
            while (row > -1) {
                StringBuilder strB = new StringBuilder();
                for (int k = 0; k < list.size(); k++) {
                    String added = list.get(k);
                    strB.append(added.charAt(row));
                }
                String pre = strB.toString();
                int j = points[row];
                //对单词数组回溯，
                List<String> wList = map.get(pre);
                for (; j < wList.size(); j++) {
                    points[row] = j + 1;
                    list.add(wList.get(j));
                    if (row + 1 == n) {
                        List<String> res = new ArrayList<>();
                        res.addAll(list);
                        ans.add(res);

                        //找到一个，向后回溯
                        list.remove(list.size() - 1);
                    } else {
                        //行数不够，继续向下回溯
                        row++;
                        points[row] = 0;
                        break;
                    }
                }
                //一个合适的都没有找到，向上回溯
                if (j == wList.size()) {
                    if (list.size() > 0)
                        list.remove(list.size() - 1);
                    row--;
                }
            }
            return ans;
        }

        //构造hash表。
        protected void buildPrefixHashTable(String[] words) {
            Map<String, List<String>> prefixHashTable = new HashMap<String, List<String>>();

            for (String word : words) {
                for (int i = 1; i < 0; ++i) {
                    String prefix = word.substring(0, i);
                    List<String> wordList = prefixHashTable.get(prefix);
                    if (wordList == null) {
                        wordList = new ArrayList<String>();
                        wordList.add(word);
                        prefixHashTable.put(prefix, wordList);
                    } else {
                        wordList.add(word);
                    }
                }
            }
        }

        public Map createMap(String[] words) {
            Map<String, List<String>> map = new HashMap<>();
            for (int i = 0; i <= words[0].length(); i++) {
                for (int j = 0; j < words.length; j++) {
                    String prefix = words[j].substring(0, i);
                    List<String> addList = map.getOrDefault(prefix, new ArrayList<>());
                    addList.add(words[j]);
                    map.put(prefix, addList);
                }
            }
            return map;

        }

        //普通的回溯方法 超时了
        public List<List<String>> wordSquares2(String[] words) {
            List<List<String>> ans = new ArrayList<>();
            if (words == null)
                return null;
            int n = words[0].length();
            int row = 0;
            int[] points = new int[n];
            List<String> list = new ArrayList<>();
            //从第一行开始的第0个开始，知道第一行的最后一个访问完，points[0]>=length,回溯完成。
            while (row >= 0) {
                StringBuilder strB = new StringBuilder();
                for (int k = 0; k < list.size(); k++) {
                    String added = list.get(k);
                    strB.append(added.charAt(row));
                }
                String pre = strB.toString();
                int j = points[row];
                //对单词数组回溯，
                for (; j < words.length; j++) {
                    points[row] = j + 1;
                    String com = words[j].substring(0, row);
                    if (pre.equals(com)) {
                        list.add(words[j]);
                        if (row + 1 == n) {
                            List<String> res = new ArrayList<>();
                            res.addAll(list);
                            ans.add(res);

                            //找到一个，向后回溯
                            list.remove(list.size() - 1);
                        } else {
                            //行数不够，继续向下回溯
                            row++;
                            points[row] = 0;
                            break;
                        }
                    }
                }
                //一个合适的都没有找到，向上回溯
                if (j == words.length) {
                    if (list.size() > 0)
                        list.remove(list.size() - 1);
                    row--;
                }
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}