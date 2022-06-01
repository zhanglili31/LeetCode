package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//剑指 Offer 29 顺时针打印矩阵
//2022-06-01 07:51:46
class ShunShiZhenDaYinJuZhenLcof {

    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {7, 8, 9}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.spiralOrder(a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            int m = matrix.length;
            if(m==0)return new int[0];
            int n = matrix[0].length;
            if(n==0)return new int[0];
            int[] ans = new int[m * n];
            int index = 0;
            int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int k = 0;
            int top=0,left=0,bottom=m-1,right=n-1;
            while (m - k * 2 > 0 && n - k * 2 > 0) {
                int[] po = {k, k};
                ans[index++] = matrix[po[0]][po[1]];
                for (int i = 0; i < dir.length; i++) {
                    while (po[0] + dir[i][0] >= top && po[0] + dir[i][0] <= bottom && po[1] + dir[i][1] >= left && po[1] + dir[i][1] <= right) {
                        po[0] += dir[i][0];
                        po[1] += dir[i][1];
                        ans[index++] = matrix[po[0]][po[1]];
                    }
                    if(i==0)top++;
                    if(i==1)right--;
                    if(i==2)bottom--;
                    if(i==3)left++;
                }
                k++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}