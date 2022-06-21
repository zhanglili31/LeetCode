package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//116 填充每个节点的下一个右侧节点指针
//2022-06-22 02:38:31
class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {
//        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

/*    class Solution {
        public Node connect(Node root) {
            if (root == null)
                return null;
            if (root.left != null) {
                root.left.next = root.right;
            }
            if (root.right != null && root.next != null) {
                root.right.next = root.next.left;
            }
            connect(root.left);
            connect(root.right);
            return root;
        }


        //层次遍历
        public Node connect2(Node root) {
            if (root == null)
                return null;
            Queue<Queue<Node>> queue = new LinkedList<Queue<Node>>();
            Queue<Node> init = new LinkedList<Node>();
            init.add(root);
            queue.add(init);
            while (!queue.isEmpty()) {
                Queue<Node> cur = queue.poll();
                Node pre = null;
                Node next = null;
                Queue<Node> nextQueue = new LinkedList<Node>();
                if (!cur.isEmpty()) {
                    pre = cur.poll();
                    if (pre.left != null)
                        nextQueue.add(pre.left);
                    if (pre.right != null)
                        nextQueue.add(pre.right);
                }
                while (!cur.isEmpty()) {
                    next = cur.poll();
                    pre.next = next;
                    pre = next;
                    if (next.left != null)
                        nextQueue.add(next.left);
                    if (next.right != null)
                        nextQueue.add(next.right);
                }
                if (!nextQueue.isEmpty()) {
                    queue.add(nextQueue);
                }

            }
            return root;
        }
    }*/
//leetcode submit region end(Prohibit modification and deletion)

}