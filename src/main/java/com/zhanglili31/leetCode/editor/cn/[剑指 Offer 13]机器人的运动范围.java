package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//剑指 Offer 13 机器人的运动范围
//2022-06-27 01:46:57
class JiQiRenDeYunDongFanWeiLcof {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.movingCount(5,5,10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount(int m, int n, int k) {
            Queue<int[]> queue = new LinkedList<int[]>();
            boolean[][] sign = new boolean[m][n];
            queue.add(new int[]{0, 0});
            sign[0][0] = true;
            int count = 0;
            int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            sign[0][0]=true;
            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                count++;
                for (int i = 0; i < dir4.length; i++) {
                    int a = dir4[i][0] + temp[0];
                    int b = dir4[i][1] + temp[1];
                    if (a >= 0 && a < m && b >= 0 && b < n && !sign[a][b] && get(a, b, k)) {
                        sign[a][b]=true;
                        queue.add(new int[]{a, b});
                    }
                }
            }
            return count;
        }

        private boolean get(int a, int b, int k) {
            int sum = 0;
            while (a > 0) {
                sum += a % 10;
                a = a / 10;
            }
            while (b > 0) {
                sum += b % 10;
                b = b / 10;
            }
            return sum <= k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}