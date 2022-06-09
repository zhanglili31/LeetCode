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
        int[][] a = {{2,1,45475},{3,2,41579},{4,1,79418},{5,2,17589},{7,5,4371},{8,5,82103},{9,7,55500}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {58732,77988,55446,79246,8265,30789,39905,79968,5555};

        System.out.println(Arrays.toString(temp));
        System.out.println(solution.minCostToSupplyWater(9, temp, a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //管道合并：如果i,j ,对于i来说，pij小于w[i],那么i就应该用j的水，他们两个用水管链接。并且将他们的边合并。并且用成本小的那个作为代表节点
        //查找每一个没有水的房子，如果与这个房子相连接的所有管道都没有，或者成本都大于房子内建水，那么这个房子就建水，否则用管道链接。
        //继续查找没有水的房子，知道所有的房子都有水。
        //贪心
        int NODE = 0;
        int HAS_WATER = 1;
        int[] wells = null;

        class Union {
            int fa[][];//0代表节点 1: 1打井 0 没有打井   2内部的所有边的和
            int rank[];//成本

            public Union(int n, int[] wells) {
                fa = new int[n + 1][3];
                rank = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    fa[i] = new int[]{i, 0, 0};
                    rank[i] = wells[i - 1];
                }
            }

            int find(int x) {
                return fa[x][NODE] = fa[x][NODE] == x ? x : find(fa[x][NODE]);
            }

            boolean merge(int i, int j, int cost) {
                int x = find(i);
                int y = find(j);
                if (x == y)
                    return false;
                if (rank[x] > rank[y] || fa[y][HAS_WATER] == 1) {
                    fa[x][NODE] = y;//head is y
                    fa[y][2] += cost;
                } else {
                    fa[y][NODE] = x;//head is x
                    fa[x][2] += cost;
                }
                return true;
            }

            //i打井 有水
            void set(int i) {
                int x = find(i);
                fa[x][HAS_WATER] = 1;
            }

            //i是否有水
            boolean haveWater(int i) {
                int x = find(i);
                return fa[x][HAS_WATER] == 1;
            }

            //获取x的成本
            int getCost(int i) {
                int x = find(i);
                return rank[x];
            }
        }

        public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
            this.wells = wells;

            int minCost = 0;
            Set<Integer> hasWaterHouses = new HashSet<Integer>();
            Map<Integer, Set<String>> edges = new HashMap<>();
            Map<String, Integer> ed = new HashMap<>();
            for (int i = 0; i < pipes.length; i++) {
                int x = pipes[i][0];
                int y = pipes[i][1];
                String e1 = x + "," + y;
                String e2 = y + "," + x;
                int cost = pipes[i][2];

                Set<String> set = edges.getOrDefault(x, new HashSet<String>());
                set.add(e1);
                edges.put(x, set);

                set = edges.getOrDefault(y, new HashSet<String>());
                set.add(e2);
                edges.put(y, set);

                ed.put(x + "," + y, cost);
                ed.put(y + "," + x, cost);
            }
            //
            Union union = new Union(n, wells);
            int k=0;
            while (hasWaterHouses.size() < n) {
                System.out.println(hasWaterHouses);
                for (int i = 1; i <= n; i++) {
                    if (hasWaterHouses.contains(i))
                        continue;
                    if (union.haveWater(i)) {
                        hasWaterHouses.add(i);
                        continue;
                    }
                    Set<String> e = edges.get(i);
                    if (e == null) {
                        hasWaterHouses.add(i);
                        System.out.println("1打井"+i);
                        minCost += union.getCost(i);
                        union.set(i);
                    } else {
                        Iterator<String> iterator = e.iterator();
                        String minPipes = null;
                        while (iterator.hasNext()) {
                            String temp = iterator.next();
                            if (minPipes == null) {
                                minPipes = temp;
                            } else if (ed.get(temp) < ed.get(minPipes)) {
                                minPipes = temp;
                            }
                        }
                        //管道的成本大于打井的成本
                        if (minPipes == null || ed.get(minPipes)>= union.getCost(i)&&k>0) {
                            union.set(i);//直接打井
                            System.out.println("2打井"+union.find(i));
                            minCost += union.getCost(i);
                        } else {
                            Set<String> e2 = edges.get(getOther(minPipes, i));
                            if (e2 != null)
                                e.addAll(e2);
                            e.remove(minPipes);
                            String a[] = minPipes.split(",");
                            e.remove(a[1] + "," + a[0]);

                            edges.put(Integer.parseInt(a[0]), e);
                            edges.put(Integer.parseInt(a[1]), e);
                            System.out.println(minPipes);

                            if (union.merge(Integer.parseInt(a[0]), Integer.parseInt(a[1]), ed.get(minPipes)))
                                minCost += ed.get(minPipes);
                        }
                    }
                    k++;

                }

            }
            return minCost;
        }

        public int getOther(String str, int i) {
            String a[] = str.split(",");
            if (Integer.parseInt(a[0]) == i) {
                return Integer.parseInt(a[1]);
            } else {
                return Integer.parseInt(a[0]);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}