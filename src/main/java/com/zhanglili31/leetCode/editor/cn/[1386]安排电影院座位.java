package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//1386 安排电影院座位
//2022-10-20 02:30:57
class CinemaSeatAllocation {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new CinemaSeatAllocation().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1}, {1, 2}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.maxNumberOfFamilies(3, a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
            return method1(n, reservedSeats);

        }

        private int method1(int n, int[][] reservedSeats) {
            int p2 = 0b11111111_11111111_11111101_11111110;
            int pl1 = 0b11111111_11111111_11111101_11100000;
            int pr2 = 0b11111111_11111111_11111100_00011110;
            int p3 = 0b11111111_11111111_11111100_01111000;
            int val = 0b11111111_11111111_11111111_11111111;// val=-1

            Map<Integer, Integer> rowsOccupiedMap = new LinkedHashMap<Integer, Integer>();
            //排，和val
            Map<Integer, Integer> map = new HashMap<>();
            int b = 1;
            for (int i = 0; i < 10; i++) {
                map.put(i, val & (~b));
                b = b << 1;
            }
            for (int i = 0; i < reservedSeats.length; i++) {
                int row = reservedSeats[i][0] - 1;
                int po = reservedSeats[i][1] - 1;
                int value = rowsOccupiedMap.getOrDefault(row, val);
                value &= map.get(po);
                rowsOccupiedMap.put(row, value);
            }
            final int[] res = {0};
            rowsOccupiedMap.forEach((key, value) -> {
                if ((p2 & value) == p2) {
                    res[0] += 2;
                } else if ((pl1 & value) == pl1) {
                    res[0] += 1;
                } else if ((pr2 & value) == pr2) {
                    res[0] += 1;
                } else if ((p3 & value) == p3) {
                    res[0] += 1;
                }
            });
            res[0] += (n - rowsOccupiedMap.size()) * 2;
            return res[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}