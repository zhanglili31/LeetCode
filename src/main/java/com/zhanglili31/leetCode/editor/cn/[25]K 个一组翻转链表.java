package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//25 K 个一组翻转链表
//2022-06-28 05:40:29
class ReverseNodesInKGroup {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new ReverseNodesInKGroup().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3,4,5]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.reverseKGroup(listNode, 2));
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
        int TAIL = 1;
        int HEAD = 0;

        public ListNode reverseKGroup(ListNode head, int k) {
            if (k == 1)
                return head;
            ListNode ans = null;
            boolean flag = true;
            ListNode[] last = null;
            while (head != null && flag) {
                ListNode[] listNode = new ListNode[2];
                flag = recursion(head, null, k, 0, listNode);
                if (flag && last != null) {
                    last[TAIL].next = listNode[HEAD];
                }
                if (ans == null) {
                    ans = listNode[HEAD];
                }
                head = listNode[TAIL].next;
                last = listNode;
            }
            return ans != null ? ans : head;

        }

        private boolean recursion(ListNode head, ListNode pre, int k, int i, ListNode[] list) {
            if (head == null) {
                return false;
            }
            if (i == 0) {
                list[TAIL] = head;
            }

            if (i + 1 == k) {
                list[HEAD] = head;
                list[TAIL].next = head.next;
                head.next = pre;
                return true;
            }
            boolean ans = recursion(head.next, head, k, i + 1, list);
            if (ans && i != 0) {
                head.next = pre;
            }
            return ans;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}