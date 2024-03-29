package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//616 给字符串添加加粗标签
//2022-05-20 21:28:13
class AddBoldTagInString {

    public static void main(String[] args) {
        Solution solution = new AddBoldTagInString().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "abcdef";
        String strArray[] = {"a", "c", "e", "g"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.addBoldTag(testStr, strArray));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //解题方式：染色
        public String addBoldTag(String s, String[] words) {
            int N = s.length();
            boolean mask[] = new boolean[N];
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < s.length(); j++) {
                    if (s.startsWith(words[i], j)) {
                        for (int k = j; k < j + words[i].length(); k++) {
                            mask[k] = true;
                        }
                    }
                }
            }
            StringBuilder ans = new StringBuilder();
            int i = 0;
            int start = 0;
            int end = 0;
            while (i < N) {
                if (i == 0 && mask[i] || i - 1 >= 0 && mask[i] && (!mask[i - 1])) {
                    start = i;
                    ans.append(s.substring(end, start));
                    ans.append("<b>");
                }
                if (i == N - 1 && mask[i] || i + 1 < N && mask[i] && (!mask[i + 1])) {
                    end = i + 1;
                    ans.append(s.substring(start, end));
                    ans.append("</b>");
                    start = end;
                } else if (i == N - 1) {
                    ans.append(s.substring(start, i + 1));
                }
                i++;

            }
            return ans.toString();

        }

        // KMP+区间合并  //超时
        public String addBoldTag2(String s, String[] words) {
            if (words.length == 0)
                return s;
            String ans = "";
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                list.addAll(KMP(s, words[i]));
            }
            if (list.size() == 0) {
                return s;
            }
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            StringBuilder str = new StringBuilder();
            int init = 0;

            int a = 0, b = 0;
            for (int i = 0; i < list.size(); i++) {
                int q1[] = list.get(i);
                a = q1[0];
                b = q1[1];
                str.append(s.substring(init, a));
                for (int j = i + 1; j < list.size(); j++) {
                    int[] q2 = list.get(j);
                    int c = q2[0];
                    int d = q2[1];
                    if (c - 1 <= b) {
                        b = Math.max(b, d);
                        list.remove(j);
                        j--;
                    }
                }
                str.append("<b>" + s.substring(a, b + 1) + "</b>");
                init = b + 1;
            }
            if (b < s.length() - 1) {
                str.append(s.substring(b + 1, s.length()));
            }
            return str.toString();
        }

        public List<int[]> KMP(String s, String p) {
            List<int[]> ans = new ArrayList<>();
            int sLen = s.length();
            int pLen = p.length();
            int[] prefixTable = createPrefixTable(p);
            int pPoints = 0;
            int sPoints = 0;
            //结束的条件就是：
            char cs = ' ';
            char cp = ' ';
            while (sPoints < sLen && pPoints < pLen && sLen - sPoints >= pLen - pPoints) {//
                cs = s.charAt(sPoints);
                cp = p.charAt(pPoints);
                if (cs == cp) {
                    if (pPoints + 1 == pLen) {
                        ans.add(new int[]{sPoints - pLen + 1, sPoints});
//                        pPoints=0;
//                        sPoints=sPoints-pLen+2;
                        pPoints = prefixTable[pPoints];
                        if (pPoints < 0) {
                            sPoints++;
                            pPoints = 0;
                        }

                    } else {
                        sPoints++;
                        pPoints++;
                    }

                } else {
                    pPoints = prefixTable[pPoints];
                    if (pPoints < 0) {
                        sPoints++;
                        pPoints = 0;
                    }
                }


            }
            return ans;
        }

        //构造p模式串的前缀表
        //构造的思路：对于p的每一个子串（从0开始，到第i个字符结束，i从1到p.length-1），获取字串的最长相等前后缀。
        //例如：aaaa 的最长就是：aaa和aaa ，长度是3
        public int[] createPrefixTable(String p) {
            if (p.length() == 0)
                return null;
            int[] prefixTable = new int[p.length()];
            prefixTable[0] = -1;
            for (int i = 2; i < p.length(); i++) {//i表示p的字串的长度
                String sub = p.substring(0, i);
                for (int j = i - 1; j > 0; j--) {//j表示p的字串的最长前缀的长度，
                    String prefix = sub.substring(0, j);
                    String suffix = sub.substring(sub.length() - j, sub.length());//后缀的截取
                    if (prefix.equals(suffix)) {
                        prefixTable[i] = j;
                        break;
                    }
                }
            }
            return prefixTable;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}