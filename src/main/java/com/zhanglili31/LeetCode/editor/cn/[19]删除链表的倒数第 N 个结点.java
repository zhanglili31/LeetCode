package com.zhanglili31.LeetCode.editor.cn;
import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//19删除链表的倒数第 N 个结点
//2021-04-20 00:44:06
class RemoveNthNodeFromEndOfList{
    public static void main(String []args){
        Solution solution=new RemoveNthNodeFromEndOfList().new Solution();
        TreeNode r=CreateTree.deserialize("[5,4,2,3,3,7]");
        System.out.println(solution);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp=head;
        while (temp != null) {
            list.add(temp);
            temp=temp.next;
        }
        int index=list.size()-n;
        ListNode tar = list.get(index);
        if (index == 0) {
            return tar.next;
        }else {
            list.get(index-1).next=list.get(index).next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
