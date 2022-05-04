package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//163 缺失的区间
//2022-05-04 09:46:17
class MissingRanges {

    public static void main(String[] args) {
        Solution solution = new MissingRanges().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int[] array = new int[nums.length + 2];
        array[0] = lower-1;
        array[array.length - 1] = upper+1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < lower) {
                array[i+1] = lower;
            }else if(nums[i]>upper){
                array[i+1] = upper;
            }else{
                array[i+1] = nums[i];
            }
        }
        System.out.println(Arrays.toString(array));
        List<String> res = new LinkedList<>();
        for (int i = 0; i < array.length - 1; i++) {
            int del = array[i + 1] - array[i];
            if(del==2){
                res.add(String.valueOf(array[i] + 1));
            } else if (del > 2) {
                res.add(String.valueOf(array[i]+1) + "->" + String.valueOf(array[i + 1] - 1));
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}