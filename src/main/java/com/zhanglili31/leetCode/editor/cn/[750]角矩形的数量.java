package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
//750 角矩形的数量
//2022-06-02 02:06:49
class NumberOfCornerRectangles {

    public static void main(String[] args) {
        Solution solution = new NumberOfCornerRectangles().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //参考：https://leetcode.cn/problems/number-of-corner-rectangles/solution/java-by-zxy0917-16/
    public int countCornerRectangles(int[][] grid) {
        int count=0;
        int m=grid.length;
        if (m <= 1)return count;
        int n=grid[0].length;
        if(n<=1)return count;
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                int edge=0;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        count+=edge;
                        edge++;
                    }
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}