package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1133 最大唯一数
//2022-06-09 20:12:41
class LargestUniqueNumber {

    public static void main(String[] args) {
        Solution solution = new LargestUniqueNumber().new Solution();
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
        //计数排序
        public int largestUniqueNumber(int[] nums) {
            int r[] = new int[1001];
            for (int i = 0; i < nums.length; i++) {
                r[nums[i]]++;
            }
            for (int i = 1000; i >= 0; i--) {
                if (r[i] == 1) {
                    return i;
                }
            }
            return -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}