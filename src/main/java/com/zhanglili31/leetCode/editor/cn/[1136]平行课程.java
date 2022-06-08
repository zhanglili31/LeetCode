package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1136 平行课程
//2022-06-08 08:28:44
class ParallelCourses {

    public static void main(String[] args) {
        Solution solution = new ParallelCourses().new Solution();
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
            int fa[] = null;
            int rank[] = null;

            public Union(int n) {
                fa = new int[n + 1];
                rank = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    fa[i] = i;
                }
            }

            int find(int x) {
                return fa[x] = fa[x] == x ? x : find(fa[x]);
            }

            boolean merge(int i, int j) {
                int x = find(i);
                int y = find(j);
                if (x == y) {
                    return false;
                }
                if (rank[x] < rank[y]) {
                    fa[x] = y;
                } else {
                    fa[y] = x;
                }
                if (rank[x] == rank[y]) {
                    rank[x]++;
                }
                return true;

            }

        }

        public int minimumSemesters(int n, int[][] relations) {
            int degree[] = new int[n + 1];
            Map<Integer, List<Integer>> edges = new HashMap<>();
//            Union union = new Union(n);
            for (int i = 0; i < relations.length; i++) {
                int x = relations[i][0];
                int y = relations[i][1];
                List<Integer> temp = edges.getOrDefault(x, new ArrayList<>());
                temp.add(y);
                edges.put(x, temp);
                degree[y]++;
//                if (!union.merge(x, y)) {
//                    return -1;
//                }

            }
            int ans = 0;
            Queue<Integer> queue = new LinkedList<>();
            boolean flag = true;
            int count=0;
            while (flag) {
                flag = false;
                for (int i = 1; i < degree.length; i++) {
                    if (degree[i] == 0) {
                        queue.add(i);
                        degree[i] = -1;
                        count++;
                    }
                }
                if (!queue.isEmpty()) {
                    ans++;
                }
                while (!queue.isEmpty()) {
                    flag = true;
                    int x = queue.poll();
                    List<Integer> temp = edges.get(x);
                    for (int i = 0; temp != null && i < temp.size(); i++) {
                        degree[temp.get(i)]--;
                    }
                }

            }
            if (count < n) {
                return -1;
            }
            return ans == 0 ? -1 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}