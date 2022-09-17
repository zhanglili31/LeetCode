package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//300 最长递增子序列
//2022-09-17 21:59:34
class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {0,1,0,3,2,3};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.lengthOfLIS(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //todo 还有更好的解决方案值得尝试
        //普通dp
        public int lengthOfLIS(int[] nums) {
            int dp[] = new int[nums.length];
            int res = 1;

            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        res = Math.max(dp[i], res);
                    }
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}