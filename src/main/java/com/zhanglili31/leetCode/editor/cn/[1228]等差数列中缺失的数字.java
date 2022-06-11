package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1228 等差数列中缺失的数字
//2022-06-11 17:44:00
class MissingNumberInArithmeticProgression {

    public static void main(String[] args) {
        Solution solution = new MissingNumberInArithmeticProgression().new Solution();
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
        public int missingNumber(int[] arr) {
            int d1 = 0;
            int d2 = 0;
            for (int i = 0; i < arr.length - 2; i++) {
                d1 = arr[i + 1] - arr[i];
                d2 = arr[i + 2] - arr[i + 1];
                if (d1 == 0 || d2 == 0) {
                    return arr[i];
                }
                if (d1 / d2 == 2) {
                    return arr[i] + d2;
                } else if (d2 / d1 == 2) {
                    return arr[i + 1] + d1;
                }
            }
            return -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}