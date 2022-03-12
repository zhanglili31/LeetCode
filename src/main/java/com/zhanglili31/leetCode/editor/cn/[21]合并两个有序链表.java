package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//21合并两个有序链表
//2021-04-20 22:59:10
class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        TreeNode r = CreateTree.deserialize("[5,4,2,3,3,7]");
        System.out.println(solution);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode res = null;
            ListNode t1 = l1;
            ListNode t2 = l2;
            ListNode temp = null;
            ListNode var = null;
            while (t1 != null && t2 != null) {
                if (t1.val < t2.val) {
                    var = t1;
                    t1 = t1.next;
                } else {
                    var = t2;
                    t2 = t2.next;
                }
                if (res == null) {
                    res = var;
                    temp = res;
                } else {
                    temp.next = var;
                    temp = temp.next;
                }
            }
            if (t1 == null) var = t2;
            else var = t1;
            if (res == null) {
                res = var;
            } else {
                temp.next = var;
                temp = temp.next;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
