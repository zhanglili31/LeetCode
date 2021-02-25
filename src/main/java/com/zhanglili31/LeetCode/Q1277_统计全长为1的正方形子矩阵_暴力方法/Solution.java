package com.zhanglili31.LeetCode.Q1277_统计全长为1的正方形子矩阵_暴力方法;
//{
//        {0,1,1,1},
//        {1,1,0,1},
//        {1,1,1,1},
//        {1,0,1,0}
//        }
//这种不算有边长为3的正方形。不能通过
public class Solution {
    public static void main(String[] args) {
        int[][] matrix={{0,1,1,1},{1,1,0,1},{1,1,1,1},{1,0,1,0}};
        System.out.println(new Solution().countSquares(matrix));
    }
    public int countSquares(int[][] matrix) {
        if(matrix==null||matrix.length==0)return 0;
        int maxLength = Math.max(matrix.length, matrix[0].length);
        int nums=0;
        for(int len=0;len<=maxLength;len++){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    //判定以i，j，为左上角的，边长为len的正方形
                    //计算上面的边长
                    int top=0;
                    for (int l1 = j; l1 <= j+len&&l1<matrix[0].length; l1++) {
                        top+=matrix[i][l1];
                    }
                    int left=0;
                    for (int l1 = i; l1 <= i+len&&l1<matrix.length; l1++) {
                        left+=matrix[l1][j];
                    }
                    int right=0;
                    for (int l1 =i; l1 <=i+len&&l1<matrix.length&&(j+len<matrix[0].length); l1++) {
                        right+=matrix[l1][j+len];
                    }
                    int bottom=0;
                    for (int l1 = j; l1 <= j+len&&l1<matrix[0].length&&(i+len<matrix.length); l1++) {
                        bottom+=matrix[i+len][l1];
                    }
                    if ((top + left + bottom + right) == (len+1) * 4) {
                        nums++;
                    }

                }
            }
        }
        return  nums;
    }
}
