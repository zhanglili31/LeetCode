package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//774 最小化去加油站的最大距离
//2022-06-04 01:09:19
class MinimizeMaxDistanceToGasStation {

    public static void main(String[] args) {
        Solution solution = new MinimizeMaxDistanceToGasStation().new Solution();
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
        public double minmaxGasDist(int[] stations, int k) {
            double min = 0;
            double max = 1e8;
            double mid = 0;
            while (max - min > 1e6) {
                mid = (max + min) / 2;
                if (check(stations, k, mid)) {
                    max = mid;
                } else {
                    min = mid;
                }
            }
            return mid;
        }

        public boolean check(int[] stations, int k, double D) {
            int used = 0;
            for (int i = 1; i < stations.length - 1; i++) {
                used += (int) ((stations[i] - stations[i - 1]) / D);
            }
            return used <= k;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}