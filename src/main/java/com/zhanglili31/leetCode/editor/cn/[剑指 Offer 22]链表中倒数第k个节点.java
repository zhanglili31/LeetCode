package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.Stack;

//剑指 Offer 22 链表中倒数第k个节点
//2022-06-01 07:29:12
class LianBiaoZhongDaoShuDiKgeJieDianLcof {

    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
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
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp=head;
        while (temp != null) {
            stack.add(temp);
            temp=temp.next;
        }
        while (k != 1) {
            stack.pop();
            k--;
        }
        return stack.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}