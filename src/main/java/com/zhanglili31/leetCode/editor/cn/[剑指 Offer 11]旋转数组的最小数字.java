package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//剑指 Offer 11 旋转数组的最小数字
//2022-05-21 01:27:43
class XuanZhuanShuZuDeZuiXiaoShuZiLcof {

    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
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
        public int minArray(int[] numbers) {
            int i = 0, j = numbers.length-1;

            int p = 0;
            while (i <= j) {
                if (j - i <= 1)
                    return Math.min(numbers[i], numbers[j]);
                p = i + (j - i) / 2;
                if (numbers[p] >= numbers[j]) {

                    i = p;
                } else {
                    j = p;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}