package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//304 二维区域和检索 - 矩阵不可变
//2022-05-30 08:19:38
class RangeSumQuery2dImmutable {

    public static void main(String[] args) {
//        Solution solution = new RangeSumQuery2dImmutable().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        //https://leetcode.cn/problems/range-sum-query-2d-immutable/solution/ru-he-qiu-er-wei-de-qian-zhui-he-yi-ji-y-6c21/
        int matrix[][] = null;
        int preSum[][] = null;
        int m = 0;
        int n = 0;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            m = matrix.length;
            n = matrix[0].length;
            preSum = new int[m][n];
            //斜着遍历
            int[] dir = {1, -1};
            for (int i = 0; i < m; i++) {
                int j = 0;
                if (i > 0) {
                    j = n - 1;
                }
                for (; j < n; j++) {
                    int a = i;
                    int b = j;
                    while (a >= 0 && a < m && b >= 0 && b < n) {
                        if (a - 1 >= 0) {
                            preSum[a][b] += preSum[a - 1][b];
                        }
                        if (b - 1 >= 0) {
                            preSum[a][b] += preSum[a][b - 1];
                        }
                        if (a - 1 >= 0 && b - 1 >= 0) {
                            preSum[a][b] -= preSum[a - 1][b - 1];
                        }
                        preSum[a][b] += matrix[a][b];
                        a += dir[0];
                        b += dir[1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int G = 0;
            if (row1 - 1 >= 0 && col1 - 1 >= 0) {
                G = preSum[row1 - 1][col1 - 1];
            }
            int E = 0;
            if (col1 - 1 >= 0) {
                E = preSum[row2][col1 - 1];
            }
            int F = 0;
            if (row1 - 1 >= 0) {
                F = preSum[row1 - 1][col2];
            }
            return preSum[row2][col2] - E - F + G;
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}