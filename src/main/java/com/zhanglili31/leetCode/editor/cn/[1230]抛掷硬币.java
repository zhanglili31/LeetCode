package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1230 抛掷硬币
//2022-06-17 22:32:43
class TossStrangeCoins {

    public static void main(String[] args) {
        Solution solution = new TossStrangeCoins().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        double temp[] = {0.5,0.5,0.5};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.probabilityOfHeads(temp, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //https://leetcode.cn/problems/toss-strange-coins/solution/gai-lu-dp-pao-zhi-ying-bi-java-by-acw_weian/
        public double probabilityOfHeads(double[] prob, int target) {
            double dp[][] = new double[prob.length][target + 2];
            dp[0][0] = 1 - prob[0];
            dp[0][1] = prob[0];
            for (int i = 1; i < prob.length; i++) {
                dp[i][0] = (1 - prob[i]) * dp[i - 1][0];
            }
//        dp[i][j]表示：当前有i枚硬币，其中j枚正面朝上的概率
            for (int i = 1; i < prob.length; i++) {
                for (int j = 1; j <= target && j <= i+1; j++) {
                    dp[i][j]=(1-prob[i])*dp[i-1][j]+prob[i]*dp[i-1][j-1];
                }
            }
            return dp[prob.length - 1][target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}