package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//494 目标和
//2022-03-12 19:54:36
class TargetSum {

    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.findTargetSumWays(temp,10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;

        public int findTargetSumWays(int[] nums, int target) {
            recursion(nums, 0, target, 0);
            return res;

        }

        //深度遍历，
        void recursion(int[] nums, int index, int target, int curVal) {
            int len = nums.length;
            if (index == len) {
                if (curVal == target) {
                    res++;
                }
                return;
            }
            recursion(nums, index + 1, target, curVal + nums[index]);
            recursion(nums, index + 1, target, curVal - nums[index]);
        }

        //动态规划 dp[ i ][ j ] = dp[ i - 1 ][ j - nums[ i ] ] + dp[ i - 1 ][ j + nums[ i ] ]
        void useDp(int nums[], int target) {
            int dp[][] = new int[1001][1001];
            for (int i = 0; i < nums.length; i++) {

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}