package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1064 不动点
//2022-06-04 07:17:07
class FixedPoint {

    public static void main(String[] args) {
        Solution solution = new FixedPoint().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int min = Integer.MAX_VALUE;

        public int fixedPoint(int[] arr) {
            int left = 0, right = arr.length - 1;
            recursion(arr, left, right);
            if (min == Integer.MAX_VALUE) {
                return -1;
            } else {
                return min;
            }
        }

        public void recursion(int[] arr, int left, int right) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == mid) {
                    min = Math.min(min, mid);
                    recursion(arr, left, mid - 1);
                    recursion(arr, mid + 1, right);
                }
                if (arr[mid] > mid) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}