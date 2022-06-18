package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//面试题 01.08 零矩阵
//2022-06-18 22:47:58
class ZeroMatrixLcci {

    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci().new Solution();
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
        public void setZeroes(int[][] matrix) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        row.add(i);
                        col.add(j);
                    }
                }
            }
            col.forEach(l -> {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][l] = 0;
                }
            });
            row.forEach(r -> {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[r][i] = 0;
                }
            });
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}