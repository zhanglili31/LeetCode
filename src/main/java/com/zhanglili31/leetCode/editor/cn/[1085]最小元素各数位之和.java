package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
//1085 最小元素各数位之和
//2022-06-07 14:42:44
class SumOfDigitsInTheMinimumNumber {

    public static void main(String[] args) {
        Solution solution = new SumOfDigitsInTheMinimumNumber().new Solution();
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
    public int sumOfDigits(int[] nums) {
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
        }
        int sum=0;
        while (min > 0) {
            sum+=min%10;
            min=min/10;
        }
        if (sum % 2 == 1) {
            return 0;
        }else{
            return 1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}