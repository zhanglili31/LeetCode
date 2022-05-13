package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//370 区间加法
//2022-05-13 18:15:34
class RangeAddition {

    public static void main(String[] args) {
        Solution solution = new RangeAddition().new Solution();
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
        //差分数组 https://leetcode.cn/problems/range-addition/solution/qu-jian-jia-fa-by-leetcode-solution/
        public int[] getModifiedArray(int length, int[][] updates) {
            int del[] = new int[length];
            for (int i = 0; i < updates.length; i++) {
                int start = updates[i][0];
                int end = updates[i][1];
                int inc = updates[i][2];

                del[start] += inc;
                if (end + 1 < length)
                    del[end + 1] -= inc;

            }
            for (int i = 1; i < length; i++) {
                del[i] = del[i - 1] + del[i];
            }
            return del;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}