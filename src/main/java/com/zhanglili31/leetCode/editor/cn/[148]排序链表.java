package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//148 排序链表
//2022-04-22 19:19:12
class SortList {

    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = {-1, 0, 1, 2, -1, -4};
        ListNode l1=  new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next=l3;
        l3.next=l4;
        System.out.println(solution.sortList(l1));
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
        //冒泡排序，超时
        public ListNode sortList(ListNode head) {
            boolean hasSwap = true;
            ListNode i = head;
            ListNode iPre = null;
            ListNode iNext = null;
            while (hasSwap) {
                hasSwap = false;
                while (i != null) {
                    iNext = i.next;
                    if (iNext != null && i.val > iNext.val) {
                        hasSwap = true;
                        if (iPre != null) {
                            iPre.next = iNext;
                        }else{
                            head=iNext;
                        }
                        i.next = iNext.next;
                        iNext.next = i;
                        ListNode temp=i;
                        i=iNext;
                        iNext=temp;
                    }
                    iPre = i;
                    i = i.next;

                }
                i=head;
                iPre=null;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}