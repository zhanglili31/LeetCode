package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1004 最大连续1的个数 III
//2022-10-17 03:36:48
class MaxConsecutiveOnesIii {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new MaxConsecutiveOnesIii().new Solution();
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
        //滑动窗口，统计窗口内的0的个数
        public int longestOnes(int[] nums, int k) {
            int zeroCount[] = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeroCount[i + 1] = zeroCount[i] + 1;
                } else {
                    zeroCount[i + 1] = zeroCount[i];
                }
            }
            int window = nums.length;
            while (window >= 0) {
                for (int i = 0; i <= nums.length - window; i++) {
                    int j = i + window;
                    int count = zeroCount[j] - zeroCount[i];
                    if (count <= k) {
                        return window;
                    }
                }
                window--;
            }
            return -1;
        }
        //深入研究下二分查找和动态规划的解决方案
    }
//leetcode submit region end(Prohibit modification and deletion)

}