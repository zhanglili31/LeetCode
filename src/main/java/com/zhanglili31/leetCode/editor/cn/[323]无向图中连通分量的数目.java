package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//323 无向图中连通分量的数目
//2022-05-07 06:27:55
class NumberOfConnectedComponentsInAnUndirectedGraph {

    public static void main(String[] args) {
        Solution solution = new NumberOfConnectedComponentsInAnUndirectedGraph().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Union {
            int[] fa;
            int rank[];

            Union(int n) {
                rank = new int[n + 1];
                fa = new int[n + 1];
                for (int i = 1; i <= n; ++i)
                    fa[i] = i;
            }

            int find(int x) {
                if (fa[x] == x)
                    return x;
                else {
                    return fa[x] = find(fa[x]);
                }

            }

            void merge(int i, int j) {
                int x = find(i);
                int y = find(j);
                if (rank[x] <= rank[y]) {
                    fa[x] = y;
                } else {
                    fa[y] = x;
                }
                if (rank[x] == rank[y] && x != y) {
                    rank[y]++;
                }
            }
        }

        public int countComponents(int n, int[][] edges) {
            Union union = new Union(n);
            int head=n;
            for (int i = 0; i < edges.length; i++) {
                if(union.find(edges[i][0])==union.find(edges[i][1]))continue;
                union.merge(edges[i][0], edges[i][1]);
                n--;
            }
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}