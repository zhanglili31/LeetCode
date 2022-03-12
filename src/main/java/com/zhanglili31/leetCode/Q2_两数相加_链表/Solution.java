package com.zhanglili31.leetCode.Q2_两数相加_链表;


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1=l1;
        ListNode t2=l2;
        ListNode head=null;
        ListNode tail=null;
        int temp=0;
        int c=0;
        int sum=0;
        while (t1 != null || t2 != null) {
            if (t1 != null & t2 != null) {
                sum = t1.val + t2.val + c;
                if (sum > 9) {
                    c=1;
                }else c=0;
                temp=sum%10;
                t1=t1.next;
                t2=t2.next;
            } else if (t1 != null) {
                sum = t1.val + c;
                if (sum > 9) {
                    c=1;
                }else c=0;
                temp=sum%10;
                t1=t1.next;
            } else if (t2 != null) {
                sum = t2.val + c;
                if (sum > 9) {
                    c=1;
                }else c=0;
                temp=sum%10;
                t2=t2.next;
            }
            if (head == null) {
                head = new ListNode(temp,null);
                tail=head;
            }else{
                tail.next=new ListNode(temp,null);
                tail=tail.next;
            }

        }
        if(c==1){
            tail.next=new ListNode(1,null);
        }
        return head;
    }
}
