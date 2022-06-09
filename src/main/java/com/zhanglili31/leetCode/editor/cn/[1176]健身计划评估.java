package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1176 健身计划评估
//2022-06-09 21:29:22
class DietPlanPerformance {

    public static void main(String[] args) {
        Solution solution = new DietPlanPerformance().new Solution();
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
        public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
            int sum = 0;
            int grade = 0;
            for (int i = 0; i < k-1; i++) {
                sum += calories[i];
            }
            for (int i = k-1; i < calories.length; i++) {
                sum += calories[i];
                if (sum < lower) {
                    grade--;
                } else if (sum > upper) {
                    grade++;
                }
                sum -= calories[i - k];
            }
            return grade;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}