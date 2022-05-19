package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//548 将数组分割成和相等的子数组
//2022-05-19 15:55:25
class SplitArrayWithEqualSum {

    public static void main(String[] args) {
        Solution solution = new SplitArrayWithEqualSum().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        int temp2[] = {1, 2, 1, 2, 1, 2, 1};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.splitArray(temp2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //解题方案： 官方前缀和+HastSet https://leetcode.cn/problems/split-array-with-equal-sum/solution/jiang-shu-zu-fen-ge-cheng-he-xiang-deng-de-zi-shu-/
        public boolean splitArray(int[] nums) {
            int n = nums.length;
            int[] sum = new int[n];
            sum[0] = nums[0];
            for (int i = 1; i < n; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }

            for (int j = 3; j < n - 3; j++) {
                Set<Integer> set = new HashSet<>();
                for (int i = 1; i + 1 < j; i++) {
                    if (sum[i] - nums[i] == sum[j] - sum[i] - nums[j])
                        set.add(sum[i] - nums[i]);
                }
                for (int k = j + 2; k < n - 1; k++) {
                    if (sum[k] - sum[j] - nums[k] == sum[n - 1] - sum[k] && set.contains(sum[n - 1] - sum[k])) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}