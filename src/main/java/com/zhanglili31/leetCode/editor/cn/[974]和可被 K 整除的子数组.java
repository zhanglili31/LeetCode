package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//974 和可被 K 整除的子数组
//2022-10-03 13:31:53
class SubarraySumsDivisibleByK {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new SubarraySumsDivisibleByK().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.subarraysDivByK(temp, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraysDivByK1(int[] nums, int k) {
            int res = 0;
            int[] preSum = new int[nums.length + 1];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            for (int i = 0; i < preSum.length - 1; i++) {
                for (int j = i + 1; j < preSum.length; j++) {
                    int sum = preSum[j] - preSum[i];
                    if (sum % k == 0) {
                        res++;
                    }
                }
            }
            return res;

        }

        //解题方案：https://leetcode.cn/problems/subarray-sums-divisible-by-k/solution/he-ke-bei-k-zheng-chu-de-zi-shu-zu-by-leetcode-sol/
        public int subarraysDivByK(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            int res = 0;
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                //避免负数的问题
                int v = (sum % k + k) % k;
                int t = map.getOrDefault(v, 0);
                res += t;
                map.put(v, t + 1);
            }
            return res;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}