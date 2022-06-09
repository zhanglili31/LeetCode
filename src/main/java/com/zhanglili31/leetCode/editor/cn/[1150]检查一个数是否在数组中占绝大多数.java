package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1150 检查一个数是否在数组中占绝大多数
//2022-06-09 20:30:35
class CheckIfANumberIsMajorityElementInASortedArray {

    public static void main(String[] args) {
        Solution solution = new CheckIfANumberIsMajorityElementInASortedArray().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 6, 6};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.isMajorityElement(temp, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMajorityElement(int[] nums, int target) {
            int n = nums.length;
            int low = 0;
            int high = 0;
            int left = 0;
            int right = n - 1;
            if (target < nums[0] || target > nums[n - 1]) {
                return false;
            }
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (target > nums[mid]) {
                    left = mid + 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else if (target == nums[mid]) {
                    right = mid;
                }
                if (left == right&&target==nums[left]) {
                    low = left;
                }
            }
            left = 0;
            right = n - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (target > nums[mid]) {
                    left = mid + 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else if (target == nums[mid]) {
                    left = mid;
                }
                if (left == right&&target==nums[left]) {
                    high = left;
                }
            }
            System.out.println(high);
            System.out.println(low);
            return high - low + 1 > n / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}