package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//912 排序数组
//2022-05-12 21:32:38
class SortAnArray {

    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(10, 10);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.sortArray(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            heapSort(nums, nums.length);
            System.out.println(Arrays.toString(nums));
            return nums;

        }

        //堆排序
        public void heapSort(int[] nums, int n) {
            if (n == 1) {
                return;
            }
            //right=2*i+2;
            for (int i = (nums.length) / 2 - 1; i >= 0; i--) {
                heapAdjust(nums, i, n);
            }
            for (int i = nums.length - 1; i > 0; i--) {
                int temp = nums[i];
                nums[i] = nums[0];
                nums[0] = temp;
                heapAdjust(nums, 0, i);
            }
        }
        //调整堆
        public void heapAdjust(int[] num, int i, int n) {
            int max = i;
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            if (left < n && num[left] > num[max]) {
                max = left;
            }
            if (right < n && num[right] > num[max]) {
                max = right;
            }
            //max 记录的是索引
            if (max != i) {
                int temp = num[i];
                num[i] = num[max];
                num[max] = temp;
                heapAdjust(num, max, n);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}