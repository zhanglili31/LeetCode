package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1067 范围内的数字计数
//2022-06-08 07:02:21
class DigitCountInRange {

    public static void main(String[] args) {
        Solution solution = new DigitCountInRange().new Solution();
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
        //暴力超时，正确的应该用数学归纳的方式计算
        public int digitsCount(int d, int low, int high) {
            int ans = 0;
            for (int i = low; i <= high; i++) {
                int temp = i;
                while (temp >= d) {
                    int k = temp % 10;
                    temp = temp / 10;
                    if (k == d) {
                        ans++;
                    }
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}