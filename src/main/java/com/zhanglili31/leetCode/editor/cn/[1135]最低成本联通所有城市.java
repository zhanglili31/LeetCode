package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1135 最低成本联通所有城市
//2022-06-10 09:54:08
class ConnectingCitiesWithMinimumCost {

    public static void main(String[] args) {
        Solution solution = new ConnectingCitiesWithMinimumCost().new Solution();
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
                fa = new int[n];
                rank = new int[n];
                for (int i = 0; i < n; i++) {
                    fa[i] = i;
                }
            }

            int find(int x) {
                return fa[x] = fa[x] == x ? x : find(fa[x]);
            }

            void merge(int i, int j) {
                int x = find(i);
                int y = find(j);
                if (rank[x] < rank[y]) {//y的高度大，y做头
                    fa[x] = y;
                } else {
                    fa[y] = x;
                }
                if (rank[x] == rank[y] && x != y) {
                    rank[x]++;
                }
            }
        }

        // Kruskal 算法，非常容易理解
        public int minimumCost(int n, int[][] connections) {
            Arrays.sort(connections, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });
            int minCost = 0;
            int edges = 0;
            Union union = new Union(n + 1);
            for (int i = 0; i < connections.length; i++) {
                int x = connections[i][0];
                int y = connections[i][1];
                int cost = connections[i][2];
                if (union.find(x) != union.find(y)) {
                    union.merge(x, y);
                    minCost += cost;
                    edges++;
                }
            }
            if (edges == n - 1) {
                return minCost;
            } else {
                return -1;
            }

        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    // Prim算法模版：参考：https://leetcode.cn/problems/connecting-cities-with-minimum-cost/solution/prims-java-pq-79ms-by-lyons-lu-124-zmle/
    class Solution2 {
        class Edge {
            int src;
            int dst;
            int cost;

            public Edge(int src, int dst, int cost) {
                this.src = src;
                this.dst = dst;
                this.cost = cost;
            }
        }

        public int minimumCost(int n, int[][] connections) {
            Map<Integer, List<Edge>> graph = buildGraph(connections);
            Set<Integer> isVisited = new HashSet<>();
            Queue<Edge> queue = new PriorityQueue<>((edge1, edge2) -> {
                return edge1.cost - edge2.cost;
            });
            return findMinCost(graph, isVisited, queue, n);


        }

        private int findMinCost(Map<Integer, List<Edge>> graph, Set<Integer> isVisited, Queue<Edge> queue, int n) {
            //init queue
            int init = 1;
            int minCost = 0;
            findNeighbors(graph, isVisited, queue, init);
            isVisited.add(init);
            while (!queue.isEmpty()) {
                Edge edge = queue.poll();
                if (isVisited.contains(edge.dst)) {
                    continue;
                }
                minCost += edge.cost;
                isVisited.add(edge.dst);
                if (isVisited.size() == n) {
                    return minCost;
                }
                findNeighbors(graph, isVisited, queue, edge.dst);
            }
            return -1;
        }

        private void findNeighbors(Map<Integer, List<Edge>> graph, Set<Integer> isVisited, Queue<Edge> queue, int i) {
            List<Edge> list = graph.getOrDefault(i,new ArrayList<>());
            for (int j = 0; j < list.size(); j++) {
                Edge edge = list.get(j);
                if (!isVisited.contains(edge.dst)) {
                    queue.add(edge);
                }
            }

        }

        private Map<Integer, List<Edge>> buildGraph(int[][] connections) {
            Map<Integer, List<Edge>> graph = new HashMap<>();
            for (int i = 0; i < connections.length; i++) {
                int x = connections[i][0];
                int y = connections[i][1];
                int cost = connections[i][2];
                List<Edge> list = graph.getOrDefault(x, new ArrayList<>());
                list.add(new Edge(x, y, cost));
                graph.put(x, list);
                list = graph.getOrDefault(y, new ArrayList<>());
                list.add(new Edge(y, x, cost));
                graph.put(y, list);
            }
            return graph;
        }

    }

}