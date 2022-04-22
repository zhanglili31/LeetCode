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
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
//        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;
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
        //方法一 冒泡排序，超时
        public ListNode sortListWithBubbles(ListNode head) {
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
                        } else {
                            head = iNext;
                        }
                        i.next = iNext.next;
                        iNext.next = i;
                        ListNode temp = i;
                        i = iNext;
                        iNext = temp;
                    }
                    iPre = i;
                    i = i.next;

                }
                i = head;
                iPre = null;
            }
            return head;
        }

        //方法二：自顶向下 归并排序
        public ListNode sortList(ListNode head) {
            if(head==null||head.next==null)return head;
            ListNode fast = head;
            ListNode slow = head;
            ListNode preSlow=null;
            while (fast != null) {
                fast = fast.next;
                preSlow=slow;
                slow = slow.next;
                if(fast!=null){
                    fast=fast.next;
                }
            }
            ListNode list1 = head;
            ListNode list2 = slow;
            preSlow.next=null;//断开
            list1=sortList(list1);
            list2=sortList(list2);
            head = merge(list1, list2);
            return head;

        }


        public ListNode merge(ListNode list1, ListNode list2) {
            ListNode head = null;
            ListNode temp = null;
            if (list1 == null && list2 == null)
                return null;
            if (list1 == null)
                return list2;
            if (list2 == null)
                return list1;
            while (list1 != null & list2 != null) {
                if (list1.val < list2.val) {
                    if (head == null) {
                        head = list1;
                        temp = head;
                    } else {
                        temp.next = list1;
                        temp = temp.next;
                    }
                    list1 = list1.next;
                } else {
                    if (head == null) {
                        head = list2;
                        temp = head;
                    } else {
                        temp.next = list2;
                        temp = temp.next;
                    }
                    list2 = list2.next;

                }
            }
            //最少有一个list=null，head=null，temp=null
            if (list1 == null) {
                temp.next = list2;

            } else {
                temp.next = list1;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}