package com.zhanglili31.LeetCode.editor.cn;
import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

//73矩阵置零
//2021-03-21 22:45:53
class SetMatrixZeroes{
    public static void main(String []args){
        Solution solution=new SetMatrixZeroes().new Solution();
        TreeNode r=CreateTree.deserialize("[5,4,2,3,3,7]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(a);
//        System.out.println(solution.setZeroes(a));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new TreeSet<Integer>();
        Set<Integer> colSet = new TreeSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        Iterator rowIter=rowSet.iterator();
        while (rowIter.hasNext()) {
            int row= (int) rowIter.next();
            for(int j=0;j<matrix[0].length;j++){
                matrix[row][j]=0;
            }
        }
        Iterator colIter=colSet.iterator();
        while (colIter.hasNext()) {
            int col= (int) colIter.next();
            for(int j=0;j<matrix.length;j++){
                matrix[j][col]=0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
