package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//547 省份数量
//2022-09-17 21:01:52
class NumberOfProvinces {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new NumberOfProvinces().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
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

            Union(int n) {
                fa = new int[n];
                rank = new int[n];
                for (int i = 0; i < n; i++) {
                    fa[i] = i;
                }
            }

            public int find(int x) {
                return fa[x] = fa[x] == x ? x : find(fa[x]);
            }

            public void merge(int i, int j) {
                int x = find(i);
                int y = find(j);
                //合并
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

        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            Union union = new Union(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isConnected[i][j] == 1) {
                        union.merge(i, j);
                        isConnected[j][i] = 0;
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (union.find(i) == i) {
                    res++;
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}