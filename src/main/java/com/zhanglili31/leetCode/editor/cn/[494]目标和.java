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
        int temp[] = {0,0,0,0,0,0,0,0,1};
        System.out.println(solution.findTargetSumWays(temp, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;

        public int findTargetSumWays(int[] nums, int target) {
//            recursion(nums, 0, target, 0);
            return useDp(nums, target);

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

        //动态规划 dp[ i ][ j ]
        int useDp(int nums[], int s) {//target 大于0
            //物品：数组中的每一个元素
            //重量：元素值
            //价值：元素值
            //背包：target
            int sum=0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum < s || (sum + s) % 2 == 1) {
                return 0;
            }
            int target=(sum+s)/2;
            int dp[][] = new int[nums.length][target + 1];
            //列初始化
            for (int i = 0; i < nums.length; i++) {
                dp[i][0] = 1;
            }
            //行初始化
            if (nums[0] <= target) {
                dp[0][nums[0]]=1;
            }
            for (int i = 1; i < nums.length; i++) {
                for (int j = 1; j <= target; j++) {
                    dp[i][j] = dp[i-1][j ];
                    if(j-nums[i]>=0) {
                        dp[i][j] += dp[i-1][j - nums[i]];
                    }
                }
            }
            return dp[nums.length - 1][target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}