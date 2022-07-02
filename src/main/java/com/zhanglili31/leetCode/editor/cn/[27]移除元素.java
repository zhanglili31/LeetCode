package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//27 移除元素
//2022-06-28 04:28:51
class RemoveElement {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new RemoveElement().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[3,2,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {3,2,2,3};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.removeElement(temp,3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            int canFill = -1;
            int ans = nums.length;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    canFill = i;
                    ans--;
                    break;
                }
            }
            if (canFill == -1)
                return nums.length;
            for (int i = canFill + 1; i < nums.length; i++) {
                if (nums[i] == val) {
                    ans--;
                } else {
                    nums[canFill] = nums[i];
                    canFill++;
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}