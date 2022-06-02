package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//711 不同岛屿的数量 II
//2022-06-02 08:22:12
class NumberOfDistinctIslandsIi {

    public static void main(String[] args) {
//        Solution solution = new NumberOfDistinctIslandsIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //todo 没做
//    class Solution {
//
////        思路：找到所有不同的岛屿，然后两两相互比较。排除
//        //岛屿旋转：比较？？
//        //
//
//
//
//        public int numDistinctIslands2(int[][] grid) {
//
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}