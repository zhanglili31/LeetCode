package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//325 和等于 k 的最长子数组长度
//2022-05-11 11:31:03
class MaximumSizeSubarraySumEqualsK {

    public static void main(String[] args) {
        Solution solution = new MaximumSizeSubarraySumEqualsK().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(1000, 10000);
        int temp2[] = {1, -1, 5, -2, 3};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.maxSubArrayLen(temp2,3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //方案一 前缀和+一次遍历 https://leetcode.cn/problems/maximum-size-subarray-sum-equals-k/solution/java-qian-zhui-he-fang-fa-zhu-xing-zhu-s-p5jb/
        public int maxSubArrayLen(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int curSum = 0;
            int ans=0;
            for (int i = 0; i < nums.length; i++) {
                curSum += nums[i];
                if (map.containsKey(curSum - k)) {
                    ans = Math.max(i - map.get(curSum - k) , ans);
                }
                if (!map.containsKey(curSum)) {
                    map.put(curSum, i);
                }

            }
            return ans;
        }
        //方案二 前缀和+滑动窗口
        public int maxSubArrayLen2(int[] nums, int k) {
            int sums[] = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
            for (int len = nums.length; len > 0; len--) {
                for (int i = 0; i <= nums.length - len; i++) {
                    int preSum = 0;
                    if (i > 0)
                        preSum = sums[i - 1];
                    if (sums[i+len-1] - preSum == k) {
                        return len;
                    }
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}