package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.StringToArray;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//85 最大矩形
//2022-03-12 20:58:59
class MaximalRectangle {

    public static void main(String[] args) {
        Solution solution = new MaximalRectangle().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        int temp[] = {-1,0,1,2,-1,-4};
        char [][]matrix=StringToArray.stringTo2DCharArray("[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]");
        System.out.println(solution.maximalRectangle(matrix));
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /*
            * 方法一: 使用柱状图的优化暴力方法
            * */
    public int maximalRectangle(char[][] matrix) {
        int res=0;
        int m = matrix.length, n = matrix[0].length;
        int left[][] = new int[m][n];
        // 初始化matrix[i][j]左边连续为1的元素个数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = j == 0 ? 1 : left[i][j - 1] + 1;
                }
            }
        }
        // 计算矩形
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int area=0;
                int height=0;
                int width = left[i][j];
                for (int k = i; k >= 0; k--) {
                    height = i - k + 1;
                    width = Math.min(width, left[k][j]);
                    area = height * width;
                    res = area > res ? area : res;
                }

            }
        }
        return res;
    }
    /*
    * todo:方法二：单调栈
    *
    *
    * */
}
//leetcode submit region end(Prohibit modification and deletion)
 
}