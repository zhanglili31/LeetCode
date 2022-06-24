package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//189 轮转数组
//2022-06-24 07:01:05
class RotateArray {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new RotateArray().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(temp));
        solution.rotate(temp, 8);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            if (k == 0)
                return;
            int n = nums.length;
            int last = nums.length - k;
            //第一轮翻转
            int left = 0, right = n - 1;
            reverse(nums, left, right);
            left = 0;
            right = k - 1;
            reverse(nums, left, right);
            left = k;
            right = n - 1;
            reverse(nums, left, right);
        }

        private void swap(int nums[], int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        private void reverse(int nums[], int left, int right) {
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}