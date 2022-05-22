package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//702 搜索长度未知的有序数组
//2022-05-23 00:24:18
class SearchInASortedArrayOfUnknownSize {

    public static void main(String[] args) {
//        Solution solution = new SearchInASortedArrayOfUnknownSize().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * // This is ArrayReader's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface ArrayReader {
     * public int get(int index) {}
     * }
     */
//无需关心边界：https://leetcode.cn/problems/search-in-a-sorted-array-of-unknown-size/solution/zui-jian-dan-de-er-fen-cha-zhao-wu-xu-guan-xin-you/
//    class Solution {
//        public int search(ArrayReader reader, int target) {
//            int left=0;
//            int right=20000;
//            int mid=0;
//            while (left <= right) {
//                mid = left + (right - left) / 2;
//                if (reader.get(mid) == target) {
//                    return mid;
//                } else if (reader.get(mid) > target) {
//                    right=mid-1;
//                }else{
//                    left=mid+1;
//                }
//            }
//            return -1;
//        }
//        //search 比较慢
//        public int search2(ArrayReader reader, int target) {
//            int left = 0;
//            int right = 0;
//            int val1 = 0, val2 = 0, mid = 0;
//            while (left<=right) {
//                val1 = reader.get(left);
//                val2 = reader.get(right);
//                if (val1 == Integer.MAX_VALUE || val1 > target) {
//                    return -1;
//                }
//                if (val1 == target) {
//                    return left;
//                }
//                if (val2 == Integer.MAX_VALUE) {
//                    break;
//                }
//                if (right == Integer.MAX_VALUE) {
//                    return right;
//                }
//                left++;
//                right += 2;
//            }
//            while (reader.get(right) == Integer.MAX_VALUE) {
//                right--;
//            }
//            if (target > reader.get(right)) {
//                return -1;
//            }
//            if (target == reader.get(right)) {
//                return right;
//            }
//            while (left < right) {
//                mid = left + (right - left) / 2;
//                if (target == reader.get(mid)) {
//                    return mid;
//                } else if (target < reader.get(mid)) {
//                    right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//            }
//            return -1;
//
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}