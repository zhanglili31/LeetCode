package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//260 只出现一次的数字 III
//2022-10-03 14:02:06
class SingleNumberIii {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new SingleNumberIii().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 5, 2, 2, 1, 3};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.singleNumber(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumber(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum ^= nums[i];
            }
            int res1 = 0;
            int res2 = 0;
            int k = 1;
            for (int i = 0; i < 31; i++) {
                if ((k & sum) == k) {
                    break;
                } else {
                    k = k << 1;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if ((k & nums[i]) == 0) {
                    res1 ^= nums[i];
                }else{
                    res2 ^= nums[i];
                }
            }
            return new int[]{res1, res2};

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}