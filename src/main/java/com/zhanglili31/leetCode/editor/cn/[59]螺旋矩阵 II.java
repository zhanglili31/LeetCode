package com.zhanglili31.leetCode.editor.cn;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
//59螺旋矩阵 II
//2021-03-16 23:39:48
class SpiralMatrixIi{
    public static void main(String []args){
        Solution solution=new SpiralMatrixIi().new Solution();
        TreeNode r=CreateTree.deserialize("[5,4,2,3,3,7]");
        System.out.println(solution.generateMatrix(3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int j=1;
        int t=0;
        while(j<=n*n){
            for (int i = 0 + t; i < n - t; i++) {
                res[t][i]=j++;
            }
            for(int i=1+t;i<n-t;i++){
                res[i][n-t-1]=j++;
            }
            for(int i=n-2-t;i>=t;i--){
                res[n-t-1][i]=j++;
            }
            for(int i=n-2-t;i>t;i--){
                res[i][t]=j++;
            }
            t++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
