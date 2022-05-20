package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//剑指 Offer 17 打印从1到最大的n位数
//2022-05-21 02:21:16
class DaYinCong1daoZuiDaDeNweiShuLcof {

    public static void main(String[] args) {
        Solution solution = new DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] printNumbers(int n) {
            int max = 1;
            for (int i = 0; i < n; i++) {
                max *= 10;
            }
            int[] ans = new int[max - 1];
            for (int i = 1; i < max; i++) {
                ans[i - 1] = i;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}