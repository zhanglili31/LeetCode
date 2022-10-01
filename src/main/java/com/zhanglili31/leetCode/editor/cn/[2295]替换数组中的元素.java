package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//2295 替换数组中的元素
//2022-09-23 10:08:50
class ReplaceElementsInAnArray {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new ReplaceElementsInAnArray().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
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
        //暴力方法
        //        public int[] arrayChange(int[] nums, int[][] operations) {
//
//            for (int i = 0; i < operations.length; i++) {
//                for (int j = 0; j < nums.length; j++) {
//                    if (nums[j] == operations[i][0]) {
//                        nums[j] = operations[i][1];
//                    }
//                }
//            }
//            return nums;
//
//        }
        public int[] arrayChange(int[] nums, int[][] operations) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }

            for (int i = 0; i < operations.length; i++) {
                int index = map.get(operations[i][0]);
                map.remove(operations[i][0]);
                map.put(operations[i][1], index);

            }
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                int key = entry.getKey();
                int value = entry.getValue();
                nums[value] = key;
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}