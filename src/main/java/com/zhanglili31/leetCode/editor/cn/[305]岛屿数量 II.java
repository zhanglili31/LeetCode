package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//305 岛屿数量 II
//2022-05-11 10:14:35
class NumberOfIslandsIi {

    public static void main(String[] args) {
        Solution solution = new NumberOfIslandsIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            class Node {
                int val;
                Set<Integer> set = null;

                Node(int val, Set<Integer> set) {
                    this.val = val;
                    this.set = set;
                }

            }

            class Union {
                int rank[] = null;
                int fa[] = null;

                Union(int num) {
                    rank = new int[num + 1];
                    fa = new int[num + 1];
                    for (int i = 0; i < num + 1; i++) {
                        fa[i] = i;
                    }
                }

                int find(int num) {
                    return fa[num] = fa[num] == num ? fa[num] : find(fa[num]);
                }

                void merge(int num1, int num2) {
                    int x = find(num1);
                    int y = find(num2);
                    if (rank[x] <= rank[y]) {//这种情况让y做头
                        fa[x] = y;
                    } else {//rank[y]>rank[x],不需要rank[y]++
                        fa[y] = x;
                    }
                    if (rank[x] == rank[y] && x != y) {
                        rank[y]++;
                    }
                }
            }

            public List<Integer> numIslands2(int m, int n, int[][] positions) {
                Union union = new Union(m * n);
                int[][] area = new int[m][n];
                List<Integer> res = new ArrayList<>();
                int init = positions[0][0] * n + positions[0][1];
                union.fa[init] = init;
                for (int i = 0; i < positions.length; i++) {
                    area[positions[i][0]][positions[i][1]] = -1;
                }
                area[positions[0][0]][positions[0][1]] = 2;
                res.add(1);
                for (int i = 1; i < positions.length; i++) {
                    int x = positions[i][0];
                    int y = positions[i][1];

                    int val = x * n + y;
                    if (area[x][y] > 0) {
                        res.add(res.get(res.size() - 1));
                        continue;
                    }
                    int nums = 0;

                    if (x - 1 >= 0 && area[x - 1][y] > 0 && union.find((x - 1) * n + y) != union.find(val)) {
                        nums++;
                        union.merge((x - 1) * n + y, val);
                    }
                    if (x + 1 < m && area[x + 1][y] > 0 && union.find((x + 1) * n + y) != union.find(val)) {
                        nums++;
                        union.merge((x + 1) * n + y, val);
                    }
                    if (y - 1 >= 0 && area[x][y - 1] > 0 && union.find(x * n + y - 1) != union.find(val)) {
                        nums++;
                        union.merge(x * n + y - 1, val);
                    }
                    if (y + 1 < n && area[x][y + 1] > 0 && union.find(x * n + y + 1) != union.find(val)) {
                        nums++;
                        union.merge(x * n + y + 1, val);
                    }
                    int len = res.get(res.size() - 1) - nums + 1;
                    area[x][y] = len;
                    res.add(len);
                }
                return res;

            }

            //判断周边集合的交集，合并小岛，这种方式可以通过，但是超过空间限制。
            public List<Integer> numIslands22(int m, int n, int[][] positions) {
                Map<Integer, Set<Integer>> islands = new HashMap<>();
                for (int i = 0; i < positions.length; i++) {
                    int x = positions[i][0];
                    int y = positions[i][1];
                    Set<Integer> set = new HashSet<>();
                    if (x - 1 >= 0) {
                        set.add((x - 1) * n + y);
                    }
                    if (x + 1 < m) {
                        set.add((x + 1) * n + y);
                    }
                    if (y - 1 >= 0) {
                        set.add(x * n + y - 1);
                    }
                    if (y + 1 < n) {
                        set.add(x * n + y + 1);
                    }
                    set.add(x * n + y);
                    islands.put(x * n + y, set);
                }
                List<Integer> res = new ArrayList<>();
                List<Node> list = new ArrayList<>();
                int init = positions[0][0] * n + positions[0][1];
                list.add(new Node(init, islands.get(init)));
                res.add(1);
                for (int i = 1; i < positions.length; i++) {
                    int x = positions[i][0];
                    int y = positions[i][1];
                    int val = x * n + y;
                    int addVal = res.get(res.size() - 1) + 1;
                    for (int j = 0; j < list.size(); j++) {
                        Set<Integer> temp = list.get(j).set;
                        int key = list.get(j).val;
                        if (temp.contains(val)) {
                            Set<Integer> valSet = islands.get(val);
                            valSet.addAll(temp);
                            addVal--;
                            list.remove(j);
                            j--;
                        }
                    }
                    list.add(new Node(val, islands.get(val)));
                    res.add(addVal);
                }
                return res;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)
 
}