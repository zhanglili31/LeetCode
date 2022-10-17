package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//875 爱吃香蕉的珂珂
//2022-10-18 05:39:31
class KokoEatingBananas {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new KokoEatingBananas().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {805306368, 805306368, 805306368};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.minEatingSpeed(temp, 1000000000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1;
            int right = 0;
            for (int i = 0; i < piles.length; i++) {
                right = Math.max(right, piles[i]);
            }
            int maxValue = right;
            while (left <= right) {
                int k = left + (right - left) / 2;
                if (canEat(piles, k, h)) {
                    maxValue = Math.min(k, maxValue);
                    right = k - 1;
                } else {
                    left = k + 1;
                }
            }
            return maxValue;
        }

        private boolean canEat(int[] piles, int k, int h) {
            for (int i = 0; i < piles.length && h >= 0; i++) {
                h -= (piles[i] + k - 1) / k;
            }
            return h >= 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}