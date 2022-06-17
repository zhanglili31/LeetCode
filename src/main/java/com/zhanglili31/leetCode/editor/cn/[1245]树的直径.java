package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1245 树的直径
//2022-06-11 21:37:55
class TreeDiameter {

    public static void main(String[] args) {
        Solution solution = new TreeDiameter().new Solution();
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
        //怎么用边构造树：
        //使用邻接表：只有一条边的
        public int treeDiameter(int[][] edges) {
            if (edges == null || edges.length == 0) {
                return 0;
            }
            Map<Integer, List<Integer>> e = new HashMap<>();
            Map<Integer, Queue<Integer>> len = new HashMap<>();
            for (int i = 0; i < edges.length; i++) {
                List<Integer> list = e.getOrDefault(edges[i][0], new LinkedList<>());
                list.add(edges[i][1]);
                e.put(edges[i][0], list);

                list = e.getOrDefault(edges[i][1], new LinkedList<>());
                list.add(edges[i][0]);
                e.put(edges[i][1], list);
            }
            Queue<Integer> queue = new LinkedList<Integer>();
            e.forEach((k, v) -> {
                if (v.size() == 1) {
                    queue.add(k);
                    Queue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o2 - o1;
                        }
                    });
                    priorityQueue.add(0);
                    len.put(k, priorityQueue);
                }
            });
            int last = 0;
            while (!queue.isEmpty()) {
                Integer cur = queue.poll();
                last = cur;
                List<Integer> list = e.get(cur);
                for (int i = 0; i < list.size(); i++) {
                    Integer n = list.get(i);
                    List<Integer> ln = e.get(n);
                    Queue<Integer> priorityQueue = len.getOrDefault(n, new PriorityQueue<Integer>(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o2 - o1;
                        }
                    }));
                    priorityQueue.add(1 + len.get(cur).peek());
                    len.put(n, priorityQueue);
                    ln.remove(cur);
                    if (ln.size() == 1) {
                        queue.add(n);
                    }
                }
            }
            int sum = 0;
            Queue<Integer> tar = len.get(last);
            for (int i = 0; i < 2 && !tar.isEmpty(); i++) {
                sum += tar.poll();
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}