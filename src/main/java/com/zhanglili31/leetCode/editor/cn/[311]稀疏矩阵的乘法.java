package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//311 稀疏矩阵的乘法
//2022-05-11 10:15:29
class SparseMatrixMultiplication {

    public static void main(String[] args) {
        Solution solution = new SparseMatrixMultiplication().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public int[][] multiply(int[][] mat1, int[][] mat2) {
                //构造mat1的稀疏矩阵
                int row1 = mat1.length;
                int col1 = mat1[0].length;
                List<List<Integer>> list1 = new ArrayList<>();
                for (int i = 0; i < row1; i++) {
                    List<Integer> temp = new ArrayList<>();
                    for (int j = 0; j < col1; j++) {
                        if (mat1[i][j] != 0) {
                            temp.add(j);
                        }
                    }
                    list1.add(temp);
                }
                int row2 = mat2.length;
                int col2 = mat2[0].length;
                List<List<Integer>> list2 = new ArrayList<>();
                for (int j = 0; j < col2; j++) {
                    List<Integer> temp = new ArrayList<>();
                    for (int i = 0; i < row2; i++) {
                        if (mat2[i][j] != 0) {
                            temp.add(i);
                        }
                    }
                    list2.add(temp);
                }
                int res[][] = new int[row1][col2];
                for (int i = 0; i < list1.size(); i++) {
                    List<Integer> row = list1.get(i);
                    for (int j = 0; j < list2.size(); j++) {
                        List<Integer> col = list2.get(j);
                        int sum = 0;
                        for (int k = 0; k < row.size(); k++) {
                            for (int l = 0; l < col.size(); l++) {
                                int colm1 = row.get(k);
                                int rowm2 = col.get(l);
                                if (colm1 == rowm2) {
                                    sum += mat1[i][colm1] * mat2[rowm2][j];
                                } else if (rowm2 > colm1) {
                                    break;
                                }
                            }
                        }
                        res[i][j] = sum;
                    }
                }
                return res;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)
 
}