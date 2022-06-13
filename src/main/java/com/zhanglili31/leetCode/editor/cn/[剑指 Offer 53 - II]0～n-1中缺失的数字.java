package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//剑指 Offer 53 - II 0～n-1中缺失的数字
//2022-06-13 15:48:56
class QueShiDeShuZiLcof {

    public static void main(String[] args) {
        Solution solution = new QueShiDeShuZiLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {0, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.missingNumber(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] == mid) {
                    left = mid + 1;
                } else if (nums[mid] > mid) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (nums[right] != right) {
                return right;
            } else {
                return right + 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}