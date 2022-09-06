package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//42 接雨水
//2022-08-31 19:34:01
class TrappingRainWater {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new TrappingRainWater().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {4,2,0,3,2,5};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.trap(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            return method1(height);

        }

        private int method1(int[] heights) {
            int sum = 0;
            for (int i = 1; i < heights.length - 1; i++) {
                int left = i - 1;
                int leftMax = heights[left];
                int right = i + 1;
                int rightMax = heights[right];
                while (left >= 0) {
                    leftMax = Math.max(leftMax, heights[left]);
                    left--;
                }
                while (right < heights.length) {
                    rightMax = Math.max(rightMax, heights[right]);
                    right++;
                }
                int val = Math.min(leftMax, rightMax) - heights[i];
                sum += val > 0 ? val : 0;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}