package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//剑指 Offer 39 数组中出现次数超过一半的数字
//2022-06-02 03:43:12
class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {

    public static void main(String[] args) {
        Solution solution = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
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
        public int majorityElement(int[] nums) {
            //投票
            int candidate = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    candidate = nums[i];
                }
                if (nums[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
            return candidate;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}