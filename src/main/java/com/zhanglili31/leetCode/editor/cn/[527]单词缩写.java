package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//527 单词缩写
//2022-06-01 23:17:00
class WordAbbreviation {

    public static void main(String[] args) {
        Solution solution = new WordAbbreviation().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strArray.length; i++) {
            list.add(strArray[i]);
        }
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.wordsAbbreviation(list));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordsAbbreviation(List<String> words) {
            List<String> ans = new ArrayList<>();
            int remain = 0;//中间保留的字母数量
            Map<String, Integer> map = new HashMap<>();
            Set<Integer> needTo = new HashSet<>();
            String temp = null;
            for (int i = 0; i < words.size(); i++) {
                temp = abbr(words.get(i), remain);
                if (map.containsKey(temp)) {
                    needTo.add(i);
                    needTo.add(map.get(temp));
                }
                map.put(temp, i);
                ans.add(temp);
            }
            remain++;
            while (needTo.size() > 0) {
                Set<Integer> swap = new HashSet<>();
                Iterator<Integer> iterator = needTo.iterator();
                while (iterator.hasNext()) {
                    int i = iterator.next();
                    String repeat = ans.get(i);
                    map.remove(repeat);
                    temp = abbr(words.get(i), remain);
                    if (map.containsKey(temp)) {
                        swap.add(i);
                        swap.add(map.get(temp));
                    }
                    ans.set(i, temp);
                    map.put(temp, i);
                }
                needTo = swap;
                remain++;
            }
            return ans;
        }

        //i表示word中间保留的单词个数，i的取之范围：  [0,word.length-2]//0表示一个都不保留，word.length表示保留全部
        //单词缩写后的长度：直接先获取缩写后的单词，计算长度，然后比较，若缩写并不比原单词更短，则保留原样。
        //字符串相加，如果中间有一个数字是0，0不会被加入到字符串中。
        public String abbr(String word, int i) {
            String abbr = word.substring(0, i + 1) + (word.length() - 2 - i) + word.charAt(word.length() - 1);
            if (abbr.length() >= word.length()) {
                return word;
            } else {
                return abbr;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}