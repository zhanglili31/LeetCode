package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//82 删除排序链表中的重复元素 II
//2022-10-16 05:30:21
class RemoveDuplicatesFromSortedListIi {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode s = new ListNode(-101);
            ListNode st = s;
            ListNode cur = head;
            ListNode repeat = new ListNode(-101);
            while (cur != null) {
                if (cur.val == repeat.val) {
                    repeat.next = cur;
                    repeat = cur;
                } else if (st.next != null && cur.val == st.next.val) {
                    repeat.next = st.next;
                    st.next.next = cur;
                    repeat = cur;

                    st.next = null;
                } else {
                    if (st.next == null) {
                        st.next = cur;
                    } else {
                        st.next.next = cur;
                        st = st.next;
                    }
                }
                cur = cur.next;

            }
            return s.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}