package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.List;

//624 数组列表中的最大距离
//2022-05-22 12:59:04
class MaximumDistanceInArrays {

    public static void main(String[] args) {
        Solution solution = new MaximumDistanceInArrays().new Solution();
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
        //动态规划的思想
        public int maxDistance(List<List<Integer>> arrays) {
            int min = arrays.get(0).get(0);
            int max = arrays.get(0).get(arrays.get(0).size() - 1);
            int ans=0;
            for (int i = 1; i < arrays.size(); i++) {
                int curMin = arrays.get(i).get(0);
                int curMax = arrays.get(i).get(arrays.get(i).size() - 1);
                ans = Math.max(ans,Math.max(Math.abs(max - curMin), Math.abs(curMax - min)));
                min = Math.min(curMin, min);
                max = Math.max(curMax, max);
            }
            return ans;

        }
        //找出最大，最小
        public int maxDistance3(List<List<Integer>> arrays) {
            int ans = 0;
            int min1 = 0;
            int min1Index = 0;
            int max1 = 0;
            int max1Index = 0;
            int min2 = 0;
            int min2Index = 0;
            int max2 = 0;
            int max2Index = 0;
            if (arrays.get(0).get(0) < arrays.get(1).get(0)) {
                min1 = arrays.get(0).get(0);
                min1Index = 0;
                min2 = arrays.get(1).get(0);
                min2Index = 1;
            } else {
                min1 = arrays.get(1).get(0);
                min1Index = 1;
                min2 = arrays.get(0).get(0);
                min2Index = 0;
            }
            if (arrays.get(0).get(arrays.get(0).size() - 1) > arrays.get(1).get(arrays.get(1).size() - 1)) {
                max1 = arrays.get(0).get(arrays.get(0).size() - 1);
                max1Index = 0;
                max2 = arrays.get(1).get(arrays.get(1).size() - 1);
                max2Index = 1;
            } else {
                max1 = arrays.get(1).get(arrays.get(1).size() - 1);
                max1Index = 1;
                max2 = arrays.get(0).get(arrays.get(0).size() - 1);
                max2Index = 0;
            }
            for (int i = 2; i < arrays.size(); i++) {
                if (min2 > arrays.get(i).get(0)) {
                    min2 = arrays.get(i).get(0);
                    min2Index = i;
                }
                if (min1 > min2) {
                    int temp = min2;
                    min2 = min1;
                    min1 = temp;
                    temp = min2Index;
                    min2Index = min1Index;
                    min1Index = temp;
                }
                if (max2 < arrays.get(i).get(arrays.get(i).size() - 1)) {
                    max2 = arrays.get(i).get(arrays.get(i).size() - 1);
                    max2Index = i;
                }
                if (max1 < max2) {
                    int temp = max2;
                    max2 = max1;
                    max1 = temp;
                    temp = max2Index;
                    max2Index = max1Index;
                    max1Index = temp;
                }
            }
            if (min1Index != max1Index) {
                ans = Math.abs(max1 - min1);
            } else {
                ans = Math.max(Math.abs(max1 - min2), Math.abs(max2 - min1));
            }
            return ans;
        }

        //方法超时
        public int maxDistance2(List<List<Integer>> arrays) {
            int ans = 0;
            int min1 = 0;
            int max1 = 0;
            int min2 = 0;
            int max2 = 0;
            for (int i = 0; i < arrays.size(); i++) {
                min1 = arrays.get(i).get(0);
                max1 = arrays.get(i).get(arrays.get(i).size() - 1);
                for (int j = i + 1; j < arrays.size(); j++) {
                    min2 = arrays.get(j).get(0);
                    max2 = arrays.get(j).get(arrays.get(j).size() - 1);
                    ans = Math.max(ans, Math.abs(max2 - min1));
                    ans = Math.max(ans, Math.abs(max1 - min2));
                }
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}