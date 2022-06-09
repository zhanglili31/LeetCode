package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1196 最多可以买到的苹果数量
//2022-06-09 21:57:43
class HowManyApplesCanYouPutIntoTheBasket {

    public static void main(String[] args) {
        Solution solution = new HowManyApplesCanYouPutIntoTheBasket().new Solution();
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
        public int maxNumberOfApples(int[] weight) {
            Arrays.sort(weight);
            int init = 5000;
            int res = 0;
            for (int i = 0; i < weight.length; i++) {
                if (weight[i] <= init) {
                    res++;
                    init -= weight[i];

                } else {
                    break;
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}