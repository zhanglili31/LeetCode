package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//360 有序转化数组
//2022-05-13 11:09:47
class SortTransformedArray {

    public static void main(String[] args) {
        Solution solution = new SortTransformedArray().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region index(Prohibit modification and deletion)
    class Solution {
        int a, b, c;

        public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
            if (nums.length == 0)
                return null;
            int ans[] = new int[nums.length];
            this.a = a;
            this.b = b;
            this.c = c;

            int i = 0;
            int j = nums.length - 1;
            int index, step;
            if (a >= 0) {
                index = nums.length - 1;
                step = -1;
            } else {
                index = 0;
                step = 1;
            }
            int val;
            while (i <= j) {
                if (a >= 0) {
                    val = f(nums[i]) > f(nums[j]) ? f(nums[i++]) : f(nums[j--]);
                } else {
                    val = f(nums[i]) > f(nums[j]) ? f(nums[j--]) : f(nums[i++]);
                }
                ans[index]=val;
                index+=step;
            }
            return ans;
        }

        public int f(int x) {
            return a * x * x + b * x + c;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}