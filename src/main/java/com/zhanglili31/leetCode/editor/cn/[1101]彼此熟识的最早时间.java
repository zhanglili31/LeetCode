package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.Comparator;

//1101 彼此熟识的最早时间
//2022-06-07 16:05:30
class TheEarliestMomentWhenEveryoneBecomeFriends {

    public static void main(String[] args) {
        Solution solution = new TheEarliestMomentWhenEveryoneBecomeFriends().new Solution();
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
            int fa[][] = null;
            int rank[] = null;

            public Union(int n) {
                fa = new int[n][2];
                rank = new int[n];
                for (int i = 0; i < n; i++) {
                    fa[i] = new int[]{i, 1};
                    rank[i] = 0;
                }
            }

            int find(int x) {
                return fa[x][0] = fa[x][0] == x ? x : find(fa[x][0]);
            }

            void merge(int i, int j) {
                int x = find(i);
                int y = find(j);
                if (x == y) {
                    return;
                }
                if (rank[x] < rank[y]) {
                    fa[x][0] = fa[y][0];
                    fa[y][1] += fa[x][1];
                } else {
                    fa[y][0] = fa[x][0];
                    fa[x][1] += fa[y][1];
                }
                if (rank[x] == rank[y]) {
                    rank[x]++;
                }

            }

        }

        public int earliestAcq(int[][] logs, int n) {
            Arrays.sort(logs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            Union union = new Union(n);
            for (int i = 0; i < logs.length; i++) {
                union.merge(logs[i][1], logs[i][2]);
                if (union.fa[union.find(logs[i][1])][1] == n) {
                    return logs[i][0];
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}