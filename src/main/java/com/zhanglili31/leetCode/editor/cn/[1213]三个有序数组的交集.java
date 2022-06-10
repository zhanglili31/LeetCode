package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1213 三个有序数组的交集
//2022-06-10 17:19:57
class IntersectionOfThreeSortedArrays {

    public static void main(String[] args) {
        Solution solution = new IntersectionOfThreeSortedArrays().new Solution();
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
        public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < arr1.length; i++) {
                if (binarySearch(arr2, arr1[i]) && binarySearch(arr3, arr1[i])) {
                    ans.add(arr1[i]);
                }
            }
            return ans;
        }

        private boolean binarySearch(int[] a, int target) {
            int left = 0;
            int right = a.length-1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target > a[mid]) {
                    left = mid + 1;
                } else if (target < a[mid]) {
                    right = mid - 1;
                } else if (target == a[mid]) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}