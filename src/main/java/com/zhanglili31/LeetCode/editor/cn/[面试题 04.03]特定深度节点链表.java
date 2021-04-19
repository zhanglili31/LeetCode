package com.zhanglili31.LeetCode.editor.cn;

import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//面试题 04.03特定深度节点链表
//2021-03-18 00:23:16
class ListOfDepthLcci {
    public static void main(String[] args) {
        Solution solution = new ListOfDepthLcci().new Solution();
        TreeNode r = CreateTree.deserialize("[1,2,3,4,5,null,7,8]");
        System.out.println(solution.listOfDepth(r));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

//Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            Queue<Queue<TreeNode>> queue = new LinkedList<>();
            Queue<TreeNode> list = new LinkedList<>();
            list.add(tree);
            queue.add(list);
            List<ListNode> arr = new ArrayList<>();
            while (!queue.isEmpty()) {
                Queue<TreeNode> temp = queue.poll();
                Queue<TreeNode> nextLine = new LinkedList<>();
                ListNode head = new ListNode(-1);
                ListNode tail = head;
                while (!temp.isEmpty()) {
                    TreeNode node = temp.poll();
                    if (node != null) {
                        if (head.val != -1) {
                            tail.next = new ListNode(node.val);
                            tail=tail.next;
                        } else {
                            head.val = node.val;
                        }
                        nextLine.add(node.left);
                        nextLine.add(node.right);
                    }
                }
                if (head.val != -1) arr.add(head);
                if (nextLine.size() > 0) queue.add(nextLine);
            }
            ListNode[] res = new ListNode[arr.size()];
            arr.toArray(res);
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
