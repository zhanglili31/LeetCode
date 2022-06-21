package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//54 螺旋矩阵
//2022-06-20 22:17:47
class SpiralMatrix {

    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
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
        public List<Integer> spiralOrder(int[][] matrix) {
            int k = 0;
            int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int m = matrix.length;
            int n = matrix[0].length;
            boolean tag[][] = new boolean[m][n];
            int init[] = {0, -1};
            List<Integer> ans = new ArrayList<>();
            while (n - k * 2 > 0 && m - k * 2 > 0) {
                for (int i = 0; i < dir.length; i++) {
                    while (init[0] + dir[i][0] >= k && init[0] + dir[i][0] < m - k &&
                            dir[i][1] + init[1] >= k && dir[i][1] + init[1] < n - k &&
                            !tag[init[0] + dir[i][0]][dir[i][1] + init[1]]) {
                        init[0] = dir[i][0] + init[0];
                        init[1] = dir[i][1] + init[1];
                        ans.add(matrix[init[0]][init[1]]);
                        tag[init[0]][init[1]] = true;

                    }
                }
                k++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}