package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//328 奇偶链表
//2022-06-24 02:25:02
class OddEvenLinkedList {

    public static void main(String[] args) {
//        Solution solution = new OddEvenLinkedList().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
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
//    class Solution {
//        public ListNode oddEvenList(ListNode head) {
//            if (head == null || head.next == null || head.next.next == null) {
//                return head;
//            }
//            ListNode tail = head.next;
//            ListNode p1 = head;
//            ListNode p2 = tail;
//            while (p1.next != null && p2.next != null) {
//                p1.next = p2.next;
//                p1 = p1.next;
//                p2.next = p1.next;
//                p2 = p2.next;
//            }
//            p1.next = tail;
//            return head;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}