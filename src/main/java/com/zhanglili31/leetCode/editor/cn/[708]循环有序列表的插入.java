package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//708 循环有序列表的插入
//2022-05-24 14:49:29
class InsertIntoASortedCircularLinkedList {

    public static void main(String[] args) {
//        Solution solution = new InsertIntoASortedCircularLinkedList().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

/*    class Solution {
        public Node insert(Node head, int insertVal) {
            Node insert = new Node(insertVal);
            if (head == null) {
                insert.next = insert;
                return insert;
            }
            Node pre = head;
            Node min = head;
            Node max = head;
            Node po = null;
            do {
                if (pre.val <= insertVal && pre.next.val >= insertVal) {
                    po = pre;
                }

                pre = pre.next;
            } while (pre != head);
            if (po != null) {
                insert.next = po.next;
                po.next = insert;
                return head;

            }
            pre = head;
            do {
                if (pre.val >= max.val) {//
                    max = pre;
                }
                pre = pre.next;
            } while (pre != head);
            min = max.next;
            System.out.println(max.val);
            System.out.println(min.val);
            if (insertVal < min.val || insertVal >= max.val) {
                //放前面
                insert.next = max.next;
                max.next = insert;
            } else {
                insert.next = min.next;
                min.next = insert;

            }
            return head;
        }
    }*/
//leetcode submit region end(Prohibit modification and deletion)

}