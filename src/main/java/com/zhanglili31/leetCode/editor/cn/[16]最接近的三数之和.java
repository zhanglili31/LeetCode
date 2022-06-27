package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//16 最接近的三数之和
//2022-06-28 03:18:38
class ThreeSumClosest {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new ThreeSumClosest().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.threeSumClosest(temp, 82));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int ans = Integer.MAX_VALUE;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1, k = nums.length - 1; j < nums.length && k > j; ) {
                    int t = nums[i] + nums[j] + nums[k];
                    if (t > target) {
                        k--;
                    } else if (t < target) {
                        j++;
                    } else if (t == target) {
                        return t;
                    }
                    int distance = Math.abs(target - t);
                    if (distance < minDistance) {
                        minDistance = distance;
                        ans = t;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}