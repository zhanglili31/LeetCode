package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//1167 连接棒材的最低费用
//2022-06-09 21:10:20
class MinimumCostToConnectSticks {

    public static void main(String[] args) {
        Solution solution = new MinimumCostToConnectSticks().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(10000, 10000);
//        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int connectSticks(int[] sticks) {
            int fee = 0;
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (int i = 0; i < sticks.length; i++) {
                priorityQueue.add(sticks[i]);
            }
            while (priorityQueue.size() > 1) {
                int x = priorityQueue.poll();
                int y = priorityQueue.poll();
                fee += x + y;
                priorityQueue.add(x + y);
            }
            return fee;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}