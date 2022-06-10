package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1197 进击的骑士
//2022-06-10 14:48:59
class MinimumKnightMoves {

    public static void main(String[] args) {
        Solution solution = new MinimumKnightMoves().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.minKnightMoves(5, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //需要注意剪枝：参考：https://leetcode.cn/problems/minimum-knight-moves/solution/cpython3-ji-yi-hua-bfsjian-zhi-jue-de-sh-5z0g/
        public int minKnightMoves(int x, int y) {
            x = Math.abs(x);
            y = Math.abs(y);
            int bottom=-2;
            int top=x+2;
            int left=-2;
            int right=y+2;
            Queue<int[]> priorityQueue = new LinkedList<int[]>();
            int dir[][] = {{-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {-2, -1}, {-2, 1}, {2, -1}, {2, 1}};
            priorityQueue.add(new int[]{0, 0, getDistance(x, y, 0, 0), 0});
            Set<String> set = new HashSet<>();
            while (!priorityQueue.isEmpty()) {
                int node[] = priorityQueue.poll();
                if (node[0] == x && node[1] == y) {
                    return node[3];
                }
                if (set.contains(node[0] + "," + node[1])) {
                    continue;
                }
                set.add(node[0] + "," + node[1]);

                for (int i = 0; i < dir.length; i++) {
                    int a = dir[i][0] + node[0];
                    int b = dir[i][1] + node[1];
                    if (a < bottom || a > top || b < left || b > right) {
                        continue;
                    }
                    if (set.contains(a + "," + b)) {
                        continue;
                    }
                    priorityQueue.add(new int[]{a, b, getDistance(x, y, a, b), node[3] + 1});
                }


            }
            return -1;
        }

        private int getDistance(int x, int y, int a, int b) {
            return Math.abs(a - x) + Math.abs(b - y);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}