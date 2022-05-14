package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//411 最短独占单词缩写
//2022-05-14 09:23:24
class MinimumUniqueWordAbbreviation {

    public static void main(String[] args) {
        Solution solution = new MinimumUniqueWordAbbreviation().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "apple";
        String strArray[] = {"blade"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.minAbbreviation(testStr, strArray));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minAbbreviation(String target, String[] dictionary) {
            List<Node> nodes = generateAbbreviations(target);
            Collections.sort(nodes, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.len - o2.len;
                }
            });
            List<String> list = new ArrayList<>();

            for (int i = 0; i < dictionary.length; i++) {
                if (target.length() == dictionary[i].length()) {
                    list.add(dictionary[i]);
                }
            }
            for (Node abbr : nodes) {
                boolean flag = false;
                for (int j = 0; j < list.size() && !flag; j++) {
                    String dic = list.get(j);
                    flag = abbrEquals(abbr.str, dic);
                }
                if (!flag) {//flag =true: 存在一个相等。 false：所有都不相等
                    return abbr.str;
                }
            }
            return null;
        }

        public boolean abbrEquals(String target, String dictionary) {
            int length = target.length();
            int j=0;
            int i = 0;
            int step=0;
            for (; i < length ; i++) {
                char ch = target.charAt(i);
                if (ch >= 'a') {
                    if(!(dictionary.charAt(j) == ch)){
                        return false;
                    };
                    j++;
                }else{
                    step = ch - '0';
                    while (i+1 < length && target.charAt(i + 1) <= '9') {
                        step*=10;
                        step += target.charAt(++i) - '0';
                    }
                    j+=step;

                }
            }
            //flag =true ;; 相等返回true；
            return j==dictionary.length();


        }

        class Node {
            String str;
            Integer len;

            Node(String str, int len) {
                this.str = str;
                this.len = len;
            }
        }

        public List<Node> generateAbbreviations(String word) {
            char[] path = new char[word.length()];
            List<Node> ans = new ArrayList<Node>();
            traceBack(word, 0, 0, path, 0, ans, 0);
            return ans;

        }

        //public 回溯
        public void traceBack(String word, int wIndex, int count, char[] path, int pIndex, List<Node> ans, int len) {
            if (wIndex == word.length()) {
                pIndex = fillNum(path, pIndex, count);
                len = count == 0 ? len : len + 1;
                ans.add(new Node(String.valueOf(path, 0, pIndex), len));
                return;
            }
            //合并为字串
            traceBack(word, wIndex + 1, count + 1, path, pIndex, ans, len);

            //处理前一个缩写数字对应的字符串，3b,b后面的字串又变成一个字问题，对字问题继续回溯，将当前的结果存储的path中。
            pIndex = fillNum(path, pIndex, count);
            path[pIndex++] = word.charAt(wIndex);
            len = count == 0 ? len + 1 : len + 2;
            traceBack(word, wIndex + 1, 0, path, pIndex, ans, len);
        }

        public int fillNum(char[] path, int pIndex, int count) {
            char[] num = null;
            num = String.valueOf(count).toCharArray();
            for (int i = 0; i < num.length && num[0] != '0'; i++) {
                path[pIndex++] = num[i];
            }
            return pIndex;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}