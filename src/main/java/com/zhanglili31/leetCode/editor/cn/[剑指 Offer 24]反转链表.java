package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
//剑指 Offer 24 反转链表
//2022-06-01 07:34:38
class FanZhuanLianBiaoLcof {

    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
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
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    ListNode root=null;
    public ListNode reverseList(ListNode head) {

        recursion(head);
        return root;

    }
    public ListNode recursion(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            root=head;
            return head;
        }
        ListNode pre = recursion(head.next);
        pre.next=head;
        head.next=null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}