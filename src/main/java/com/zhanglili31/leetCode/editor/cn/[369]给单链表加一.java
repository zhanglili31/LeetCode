package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//369 给单链表加一
//2022-05-13 17:48:14
class PlusOneLinkedList {

    public static void main(String[] args) {
        Solution solution = new PlusOneLinkedList().new Solution();
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

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        //参考解决方案：https://leetcode.cn/problems/plus-one-linked-list/solution/c-kuai-man-zhi-zhen-bu-fan-zhuan-lian-biao-by-kao-/
        public ListNode plusOne(ListNode head) {
            ListNode fast = head;
            ListNode slow = new ListNode(0);
            slow.next = head;
            while (fast != null) {
                if (fast.val != 9) {
                    slow = fast;
                }
                fast = fast.next;
            }
            slow.val++;
            ListNode curNode = slow.next;
            while (curNode != null) {
                curNode.val = 0;
                curNode=curNode.next;
            }
            return slow.next == head ? slow : head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}