package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1162 地图分析
//2022-10-18 03:47:08
class AsFarFromLandAsPossible {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new AsFarFromLandAsPossible().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
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
        public int maxDistance(int[][] grid) {
            List<int[]> ocean = new ArrayList<>();
            List<int[]> land = new ArrayList<>();
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 0) {
                        ocean.add(new int[]{i, j});
                    } else {
                        land.add(new int[]{i, j});
                    }
                }
            }
            if (ocean.size() == m * n || land.size() == m * n) {
                return -1;
            }
            int maxDistance = 0;
            for (int i = 0; i < ocean.size(); i++) {
                int sea[] = ocean.get(i);
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < land.size(); j++) {
                    int area[] = land.get(j);
                    int distance = Math.abs(sea[0] - area[0]) + Math.abs(sea[1] - area[1]);
                    min = Math.min(min, distance);

                }
                maxDistance = Math.max(maxDistance, min);
            }
            return maxDistance;

        }
        //todo 深入研究各种情况
    }
//leetcode submit region end(Prohibit modification and deletion)

}