package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//334 递增的三元子序列
//2022-06-24 00:04:59
class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        Solution solution = new IncreasingTripletSubsequence().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
//        int temp[] = {0, 4, 2, 1, 0, -1, -3};
//        int[] temp = {2, 1, 5, 0, 4, 6};
        int temp[] = {1, 5, 0, 4, 1, 3};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.increasingTriplet(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public boolean increasingTriplet(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(nums[0], 1);
            for (int i = 1; i < nums.length; i++) {
                Iterator iterator = map.entrySet().iterator();
                Map<Integer, Integer> map2 = new HashMap<>();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) iterator.next();
                    map2.put(nums[i], map2.getOrDefault(nums[i], 1));
                    if (entry.getKey() < nums[i]) {
                        int c = map2.get(nums[i]);
                        if (entry.getValue() + 1 > c) {
                            if (entry.getValue() + 1 == 3) {
                                return true;
                            }
                            map2.put(nums[i], entry.getValue() + 1);
                        }
                    }
                    if (!map2.containsKey(entry.getKey())) {
                        map2.put(entry.getKey(), entry.getValue());
                    }
                }
                map = map2;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}