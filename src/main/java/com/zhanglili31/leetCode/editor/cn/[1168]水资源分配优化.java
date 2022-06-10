package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1168 水资源分配优化
//2022-06-09 12:25:17
class OptimizeWaterDistributionInAVillage {

    public static void main(String[] args) {
        Solution solution = new OptimizeWaterDistributionInAVillage().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{2, 1, 45475}, {3, 2, 41579}, {4, 1, 79418}, {5, 2, 17589}, {7, 5, 4371}, {8, 5, 82103}, {9, 7, 55500}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {58732, 77988, 55446, 79246, 8265, 30789, 39905, 79968, 5555};

        System.out.println(Arrays.toString(temp));
        System.out.println(solution.minCostToSupplyWater(9, temp, a));
    }

    //Prim算法
    class Solution2 {
        class Edge {
            int toward, cost;

            Edge(int toward, int cost) {
                this.toward = toward;
                this.cost = cost;
            }
        }

        public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
            int sum = 0;
            List<Edge>[] graph = new List[n];
            for (int i = 0; i < n; i++)
                graph[i] = new LinkedList<>(); //init graph
            for (int[] p : pipes) { //undirected! add twice
                graph[p[0] - 1].add(new Edge(p[1] - 1, p[2]));
                graph[p[1] - 1].add(new Edge(p[0] - 1, p[2]));
            }
            //prim processing, starts from the well
            int[] costs = wells, visited = new int[n];


            for (int i = 0; i < n; i++) {
                int next = -1;
                for (int j = 0; j < n; j++)
                    if (visited[j] != 1 && (next == -1 || costs[j] < costs[next]))
                        next = j;
                sum += costs[next];
                visited[next] = 1;
                graph[next].forEach(e -> costs[e.toward] = Math.min(costs[e.toward], e.cost));
            }
            return sum;
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Union {
            int fa[];
            int rank[];

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

            void merge(int i, int j) {
                int x = find(i);
                int y = find(j);
                if (rank[x] < rank[y]) {//y的高度大于x，高度大的y作为head
                    fa[x] = y;
                } else {//x的高度大于等于y，x为head
                    fa[y] = x;
                }
                if (rank[x] == rank[y] && x != y) {
                    rank[x]++;
                }
            }
        }

        //Prim算法和Kruskal算法 https://zhuanlan.zhihu.com/p/34922624
        //参考题解：https://leetcode.cn/problems/optimize-water-distribution-in-a-village/solution/java-kruskal-prim-by-cakipaul-5sqp/
        public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
            int ans = 0;
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < wells.length; i++) {
                list.add(new int[]{0, i + 1, wells[i]});
            }
            for (int i = 0; i < pipes.length; i++) {
                list.add(pipes[i]);
            }
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });
            Union union = new Union(n);
            for (int i = 0; i < list.size(); i++) {
                int e[] = list.get(i);
                int x = e[0];
                int y = e[1];
                int cost = e[2];
                if (union.find(x) != union.find(y)) {
                    union.merge(x, y);
                    ans += cost;
                }
            }
            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}