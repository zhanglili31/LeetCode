package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//454 四数相加 II
//2022-06-22 21:58:51
class FourSumIi {

    public static void main(String[] args) {
        Solution solution = new FourSumIi().new Solution();
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
        //使用两个hashmap将问题转化为两数相加问题
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    int v = nums1[i] + nums2[j];
                    map1.put(v, map1.getOrDefault(v, 0) + 1);
                    v = nums3[i] + nums4[j];
                    map2.put(v, map2.getOrDefault(v, 0) + 1);
                }
            }
            int ans = 0;
            Iterator<Map.Entry<Integer, Integer>> iterator = map1.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                ans += map2.getOrDefault(0 - entry.getKey(), 0) * entry.getValue();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}