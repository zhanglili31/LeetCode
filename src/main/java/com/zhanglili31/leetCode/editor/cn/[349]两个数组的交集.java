package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//349 两个数组的交集
//2022-06-23 06:24:22
class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
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
        public int[] intersection(int[] nums1, int[] nums2) {
            int arr[][] = new int[1001][2];
            for (int i = 0; i < nums1.length; i++) {
                arr[nums1[i]][0]++;
            }
            for (int i = 0; i < nums2.length; i++) {
                arr[nums2[i]][1]++;
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                int n = Math.min(arr[i][0], arr[i][1]);
                if (n > 0) {
                    list.add(i);
                }
            }
            int ans[] = new int[list.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}