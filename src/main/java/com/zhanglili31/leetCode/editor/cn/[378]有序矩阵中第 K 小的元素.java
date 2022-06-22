package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//378 有序矩阵中第 K 小的元素
//2022-06-23 03:00:09
class KthSmallestElementInASortedMatrix {

    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.kthSmallest(a, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //归并排序
        public int kthSmallest(int[][] matrix, int k) {
            Queue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int m = matrix.length;
            int n = matrix[0].length;
            Set<Integer> set = new HashSet<>();
            priorityQueue.add(new int[]{matrix[0][0], 0, 0});
            int th = 0;
            int ans = 0;
            int dir[][] = {{0, 1}, {1, 0}};

            while (th < k) {
                int[] head = priorityQueue.poll();
                ans = head[0];
                for (int i = 0; i < dir.length; i++) {
                    int a = head[1] + dir[i][0];
                    int b = head[2] + dir[i][1];
                    if (a >= 0 && a < m && b >= 0 && b < n && !set.contains(a * n + b)) {
                        priorityQueue.add(new int[]{matrix[a][b], a, b});
                        set.add(a * n + b);
                    }
                }
                th++;
            }
            return ans;
        }
        //todo 复习一遍240,并且用二分查找再做一遍
    }
//leetcode submit region end(Prohibit modification and deletion)

}