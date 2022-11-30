package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//1497 检查数组对是否可以被 k 整除
//2022-10-20 07:23:05
class CheckIfArrayPairsAreDivisibleByK {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new CheckIfArrayPairsAreDivisibleByK().new Solution();
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
        //可以判断一部分：
        /*
        以下情况不行：
        [5,5,1,2,3,4]
            10
         */
        public boolean canArrange(int[] arr, int k) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int mod = 0;
            for (int i = 0; i < arr.length; i++) {
                mod = arr[i] % k + k;
                mod %= k;
                int t = map.getOrDefault(mod, 0);
                map.put(mod, t + 1);
            }
            for (int key : map.keySet()) {
                int v = map.getOrDefault(k - key, 0);
                v += map.get(key);
                if (v % 2 != 0) {
                    return false;
                }
            }
            return true;


        }

        private boolean method1(int[] arr, int k) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i] % k;
            }
            return sum % k == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}