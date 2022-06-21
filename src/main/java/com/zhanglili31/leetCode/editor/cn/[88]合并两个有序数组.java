package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//88 合并两个有序数组
//2022-06-20 22:57:38
class MergeSortedArray {

    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
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

        //逆向合并，三指针
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int n1 = m - 1;
            int n2 = n - 1;
            int i = n + m - 1;
            while (i >= n1 && i >= 0) {
                if (n1 >= 0 && n2 >= 0 && nums1[n1] > nums2[n2]) {
                    nums1[i] = nums1[n1];
                    n1--;
                } else if (n2 >= 0) {
                    nums1[i] = nums2[n2];
                    n2--;
                }
                i--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}