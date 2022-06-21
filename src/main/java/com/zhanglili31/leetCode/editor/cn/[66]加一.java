package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//66 加一
//2022-06-21 00:01:15
class PlusOne {

    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
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
        public int[] plusOne(int[] digits) {
            int n = digits.length - 1;
            digits[n]++;
            while (digits[n] == 10) {
                digits[n] = 0;
                if (n - 1 < 0) {
                    int[] ans = new int[digits.length + 1];
                    ans[0] = 1;
                    for (int j = 1; j < ans.length; j++) {
                        ans[j] = digits[j - 1];
                    }
                    return ans;
                } else {
                    digits[--n]++;
                }
            }
            return digits;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}