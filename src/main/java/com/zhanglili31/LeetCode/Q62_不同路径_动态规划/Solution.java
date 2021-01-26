package com.zhanglili31.LeetCode.Q62_不同路径_动态规划;
//执行用时：0ms,在所有Java提交中击败了100.00%的用户
//内存消耗：35.3MB,在所有Java提交中击败了52.70%的用户
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] a = new int[m][n];
        for(int i=0;i<m;i++){
            a[i][0]=1;
        }
        for(int i=0;i<n;i++){
            a[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                a[i][j] = a[i - 1][j] + a[i][j - 1];
            }
        }
        return a[m][n];
    }
}
