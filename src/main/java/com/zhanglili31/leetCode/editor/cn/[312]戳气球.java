package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//312 戳气球
//2022-05-03 20:50:13
class BurstBalloons {

    public static void main(String[] args) {
        Solution solution = new BurstBalloons().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = CreateArray.getArray(300, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.maxCoins(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        方法一：动态规划 --参考：https://leetcode-cn.com/problems/burst-balloons/solution/dong-tai-gui-hua-tao-lu-jie-jue-chuo-qi-qiu-wen-ti/
        public int maxCoins(int[] nums){
            int n=nums.length;
            int points[] = new int[n + 2];
            for (int i = 1; i < n + 1; i++) {
                points[i] = nums[i - 1];
            }
            points[0]=1;
            points[n+1]=1;
            int dp[][] = new int[n + 2][n + 2];
            for (int i = n; i >= 0; i--) {
                for (int j = i+1; j < n + 2; j++) {//
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k]*points[j]);
                    }

                }
            }
            return dp[0][n + 1];

        }
        //
        // 方法二：DFS 通过查找所有情况的最大值，获取结果，但是可能复杂度很高，导致超时
        public int maxCoins2(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            return maxCoinsDFS(list);
        }
        public int maxCoinsDFS(List<Integer> list) {
            if(list.size()==0)return 0;
            int val = 0;
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < list.size(); i++) {
                int left = (i - 1 < 0) ? 1 : list.get(i - 1);
                int right = (i + 1 >= list.size()) ?1:list.get(i + 1);
                val = left * list.get(i) * right;
                List<Integer> temp = new ArrayList<>(list);
                temp.remove(i);
                int next = maxCoinsDFS(temp);
                maxValue = Math.max(maxValue, next + val);
            }
            System.out.println(maxValue);
            return maxValue;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}