package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//122 买卖股票的最佳时机 II
//2022-06-25 05:37:32
class BestTimeToBuyAndSellStockIi {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
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
    class Solution {
        //121 只能交易一次的解法：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
        public int maxProfit2(int[] prices) {
            int min = Integer.MAX_VALUE;
            int ans = 0;
            for (int i = 0; i < prices.length; i++) {
                min = Math.min(min, prices[i]);
                ans = Math.max(prices[i] - min, ans);
            }
            return ans;
        }

        //单调栈
        public int maxProfit(int[] prices) {
            Deque<Integer> queue = new LinkedList<>();
            int ans = 0;
            queue.add(prices[0]);
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] >= queue.peekLast()) {
                    queue.add(prices[i]);
                } else {
                    ans += queue.peekLast() - queue.peekFirst();
                    queue.clear();
                    queue.add(prices[i]);
                }
            }
            if (!queue.isEmpty()) {
                ans += queue.peekLast() - queue.peekFirst();
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}