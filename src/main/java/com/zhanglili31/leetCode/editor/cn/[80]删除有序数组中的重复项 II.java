package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//80 删除有序数组中的重复项 II
//2022-10-16 05:01:07
class RemoveDuplicatesFromSortedArrayIi {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.removeDuplicates(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length < 3) {
                return nums.length;
            }
            int slow = 2;
            int fast = 2;
            while (fast < nums.length) {
                if (nums[fast] != nums[slow - 2]) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;

            }
            System.out.println(slow);
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}