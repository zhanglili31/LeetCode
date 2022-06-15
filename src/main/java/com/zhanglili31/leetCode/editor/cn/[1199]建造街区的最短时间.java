package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//1199 建造街区的最短时间
//2022-06-15 18:04:17
class MinimumTimeToBuildBlocks {

    public static void main(String[] args) {
        Solution solution = new MinimumTimeToBuildBlocks().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
//        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minBuildTime(int[] blocks, int split) {
            Queue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (int i = 0; i < blocks.length; i++) {
                q.add(blocks[i]);
            }
            while (q.size() > 1) {
                int b1 = q.poll();
                int b2 = q.poll();
                int merge = Math.max(b1, b2) + split;
                q.add(merge);
            }
            return q.poll();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}