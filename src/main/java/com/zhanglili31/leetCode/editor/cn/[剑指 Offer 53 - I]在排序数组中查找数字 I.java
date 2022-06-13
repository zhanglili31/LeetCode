package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//剑指 Offer 53 - I 在排序数组中查找数字 I
//2022-06-13 15:40:26
class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {

    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
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
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int index = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target > nums[mid]) {
                    left = mid + 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else if (target == nums[mid]) {
                    index = mid;
                    break;
                }
            }

            if (index != -1) {
                int count = 1;
                for (int i = index + 1; i < nums.length; i++) {
                    if (nums[i] == target) {
                        count++;
                    } else {
                        break;
                    }
                }
                for (int j = index - 1; j >= 0; j--) {
                    if (nums[j] == target) {
                        count++;
                    } else {
                        break;
                    }
                }
                return count;
            } else {
                return 0;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}