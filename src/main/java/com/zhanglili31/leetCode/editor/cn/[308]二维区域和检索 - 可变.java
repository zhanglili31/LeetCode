package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//308 二维区域和检索 - 可变
//2022-05-11 10:25:41
class RangeSumQuery2dMutable {

    public static void main(String[] args) {
//        Solution solution = new RangeSumQuery2dMutable().new Solution();
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
    //参考题解：https://leetcode.cn/problems/range-sum-query-2d-mutable/solution/wu-xu-xian-duan-shu-de-gao-xiao-jie-fa-20ms-ji-bai/
    class NumMatrix {
        int[][] rowSum = null;
        int[][] matrix = null;
        int m = 0;
        int n = 0;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            m = matrix.length;
            n = matrix[0].length;
            rowSum = new int[m][n];
            for (int i = 0; i < m; i++) {
                rowSum[i][0] = matrix[i][0];
                for (int j = 1; j < n; j++) {
                    rowSum[i][j] = rowSum[i][j - 1] + matrix[i][j];
                }
            }
        }

        public void update(int row, int col, int val) {
            Object o=this;
            int del = val - matrix[row][col];
            this.matrix[row][col] = val;
            for (int i = col; i < n; i++) {
                rowSum[row][i]+=del;
            }
        }

        int getSum(int rowTop, int rowBottom, int col) {
            Object o=this;
            if(col<0)return 0;
            int sum=0;
            for (int i = rowTop; i <= rowBottom; i++) {
                sum += rowSum[i][col];
            }
            return sum;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            Object o=this;
            return  getSum(row1, row2, col2)-getSum(row1, row2, col1 - 1) ;

        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}