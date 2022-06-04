package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1063 有效子数组的数目
//2022-06-04 06:58:38
class NumberOfValidSubarrays {

    public static void main(String[] args) {
        Solution solution = new NumberOfValidSubarrays().new Solution();
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
//1 初始化:每一个数组的元素单独作为一个集合所以ans=nums.length
//2 以第一个元素nums[left]为最左边的元素，从这个元素以后，遍历每一个元素nums[right]
//    如果：nums[right]>=nums[left] 则：集合数量加一
//    否则：以nums[left]为最左边元素的集合就遍历完啦，left向后走一步，进入下一轮循环
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int validSubarrays(int[] nums) {
            int ans = nums.length;
            for (int left = 0; left < nums.length - 1; left++) {
                for (int right = left + 1; right < nums.length; right++) {
                    if (nums[right] >= nums[left]) {
                        ans++;
                    } else {
                        break;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}