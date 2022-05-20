package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
//剑指 Offer 18 删除链表的节点
//2022-05-21 02:30:14
class ShanChuLianBiaoDeJieDianLcof {

    public static void main(String[] args) {
        Solution solution = new ShanChuLianBiaoDeJieDianLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
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
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null)return null;
        if (head.val == val) {
            return head.next;
        }
        ListNode temp=head.next;
        ListNode pre=head;
        while (temp != null) {
            if (temp.val == val) {
                pre.next = temp.next;
                return head;
            }else{
                pre=temp;
                temp=temp.next;
            }
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}