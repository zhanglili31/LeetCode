package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//799 香槟塔
//2022-10-15 10:14:53
class ChampagneTower {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new ChampagneTower().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.champagneTower(2, 1, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //模拟过程
        public double champagneTower(int poured, int query_row, int query_glass) {
            double[][] glass = new double[100][100];
            glass[0][0] = poured;
            for (int i = 1; i <= query_row; i++) {
                glass[i][0] = getOver(glass[i - 1][0]);
                glass[i][i] = getOver(glass[i - 1][i - 1]);
                for (int j = 1; j < i; j++) {
                    glass[i][j] = getOver(glass[i - 1][j - 1]) + getOver(glass[i - 1][j]);
                }
            }
            double res = glass[query_row][query_glass];
            if (res > 1) {
                return 1;
            } else {
                return res;
            }
        }

        private double getOver(double v) {
            if (v > 1) {
                return (v - 1) / 2;
            } else {
                return 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}