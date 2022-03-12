package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//885螺旋矩阵 III
//2021-03-16 23:35:10
class SpiralMatrixIii {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIii().new Solution();
        TreeNode r = CreateTree.deserialize("[5,4,2,3,3,7]");
        System.out.println(solution.spiralMatrixIII(1,4,0,0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
            int [][]foot=new int[R*C][2];
            int [][]res=new int[R][C];
            int j=1;
            int step=1;
            while (j <= R * C) {
                for (int i = 0;  i < step; i++, c0++) {
                    if (c0>-1&&r0>-1&&c0 < C && r0 < R) {
                        res[r0][c0]=j++;
                        foot[j-2][0]=r0;
                        foot[j-2][1]=c0;
                    }
                }
                for (int i = 0;  i < step; i++, r0++) {
                    if (c0>-1&&r0>-1&&c0 < C && r0 < R) {
                        res[r0][c0]=j++;
                        foot[j-2][0]=r0;
                        foot[j-2][1]=c0;
                    }
                }
                step++;
                for (int i = 0; i < step; i++, c0--) {
                    if (c0>-1&&r0>-1&&c0 < C && r0 < R) {
                        res[r0][c0]=j++;
                        foot[j-2][0]=r0;
                        foot[j-2][1]=c0;
                    }
                }
                for (int i = 0;  i < step; i++, r0--) {
                    if (c0>-1&&r0>-1&&c0 < C && r0 < R) {
                        res[r0][c0]=j++;
                        foot[j-2][0]=r0;
                        foot[j-2][1]=c0;
                    }
                }
                step++;
            }
            return foot;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
