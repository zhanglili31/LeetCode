package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
//1099 小于 K 的两数之和
//2022-06-08 10:14:20
class TwoSumLessThanK {

    public static void main(String[] args) {
        Solution solution = new TwoSumLessThanK().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int sum=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] < k) {
                    sum = Math.max(nums[i] + nums[j], sum);
                }
            }
        }
        if (sum == Integer.MIN_VALUE) {
            return -1;
        }else{
            return sum;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}