package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1274 矩形内船只的数目
//2022-06-19 17:50:23
class NumberOfShipsInARectangle {

    public static void main(String[] args) {
        Solution solution = new NumberOfShipsInARectangle().new Solution();
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

    /**
     * // This is Sea's API interface.
     * // You should not implement it, or speculate about its implementation
     * class Sea {
     * public boolean hasShips(int[] topRight, int[] bottomLeft);
     * }
     */

    class Solution {
//        public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
//            if (topRight[0] < 0 || topRight[1] < 0 || bottomLeft[0] < 0 || bottomLeft[1] < 0) {
//                return 0;
//            }
//            if (!sea.hasShips(topRight, bottomLeft)) {
//                return 0;
//            }
//            //计算曼哈顿距离
//            int distance = topRight[0] - bottomLeft[0] + topRight[1] - bottomLeft[1];
//            if (distance == 0) {
//                return 1;
//            }
//
//            int[] mid = {(topRight[0] + bottomLeft[0] + 1) / 2, (topRight[1] + bottomLeft[1] + 1) / 2};
//
//
//            return countShips(sea, topRight, mid) +
//                    countShips(sea, new int[]{mid[0] - 1, mid[1] - 1}, bottomLeft) +
//                    countShips(sea, new int[]{mid[0] - 1, topRight[1]}, new int[]{bottomLeft[0], mid[1]}) +
//                    countShips(sea, new int[]{topRight[0], mid[1] - 1}, new int[]{mid[0], bottomLeft[1]});
//
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}