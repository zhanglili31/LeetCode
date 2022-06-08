package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
//1121 将数组分成几个递增序列
//2022-06-08 07:46:46
class DivideArrayIntoIncreasingSequences {

    public static void main(String[] args) {
        Solution solution = new DivideArrayIntoIncreasingSequences().new Solution();
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
    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        int n=nums.length;
        int repeat=1;
        int last = nums[0];
        int cur=1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == last) {
                cur++;
                repeat = Math.max(cur, repeat);
            }else{
                last=nums[i];
                cur=1;
            }
        }
        return n>=k*repeat;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}