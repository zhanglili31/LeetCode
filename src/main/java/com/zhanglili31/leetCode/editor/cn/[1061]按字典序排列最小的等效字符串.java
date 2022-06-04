package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1061 按字典序排列最小的等效字符串
//2022-06-04 04:33:33
class LexicographicallySmallestEquivalentString {

    public static void main(String[] args) {
        Solution solution = new LexicographicallySmallestEquivalentString().new Solution();
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
            int[] fa;
            int[] rank;

            public Union(int n) {
                fa = new int[n];//n==26
                rank = new int[n];
                for (int i = 0; i < n; i++) {
                    fa[i] = i;
                    rank[i]=i;
                }
            }

            public int find(int n) {
                return fa[n] = fa[n] == n ? n : find(fa[n]);
            }

            public void merge(int i, int j) {
                int x = find(i);
                int y = find(j);
                if (rank[x] < rank[y]) {//1<0  x小于y,x就做头
                    fa[y] = x;
                } else {
                    fa[x] = y;
                }
                if (rank[x] == rank[y] && x != y) {
                    rank[y]++;
                }

            }


        }

        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            Union union = new Union(26);
            for (int i = 0; i < s1.length(); i++) {
                union.merge(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
            }
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < baseStr.length(); i++) {
                int index = 'a' + union.find(baseStr.charAt(i) - 'a');
                char ch = (char) index;
                str.append(ch);
            }
            return str.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}