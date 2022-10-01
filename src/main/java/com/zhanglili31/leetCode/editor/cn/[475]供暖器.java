package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//475 供暖器
//2022-10-01 13:52:50
class Heaters {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new Heaters().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923};
        int heaters[] = {823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.findRadius(temp, heaters));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int left = 0;
            int n = houses.length;
            int right = Math.max(houses[n - 1], heaters[heaters.length - 1]);
            int minRadius = right;
            while (left < right) {
                int midRadius = left + (right - left) / 2;
                if (isCover(midRadius, houses, heaters)) {
                    right = midRadius;
                    minRadius = Math.min(minRadius, right);
                } else {
                    left = midRadius + 1;
                }
            }
            return minRadius;

        }

        private boolean isCover(int radius, int houses[], int[] heaters) {
            int begin = 0;
            for (int i = 0; i < heaters.length && begin < houses.length; i++) {
                int left = heaters[i] - radius;
                int right = heaters[i] + radius;
                for (int j = begin; j < houses.length; j++) {
                    if (left <= houses[j] && houses[j] <= right) {
                        begin++;
                    } else {
                        break;
                    }
                }
            }
            return begin == houses.length;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}