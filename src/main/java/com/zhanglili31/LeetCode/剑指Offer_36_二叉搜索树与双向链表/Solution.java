package com.zhanglili31.LeetCode.剑指Offer_36_二叉搜索树与双向链表;
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
class Solution {
    public static void main(String[] args) {
        Node node1 = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(1);
        Node node5 = new Node(3);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        new Solution().treeToDoublyList(node1);

    }
    public Node treeToDoublyList(Node root) {
        recure(root);
        Node head = findPre(root);
        Node tail = findPro(root);
        head.left=tail;
        tail.right=head;
        return head;
    }

    private Node recure( Node root) {
        if(root==null)return null;
        recure(root.left);
        recure(root.right);
        Node pre = findPro(root.left);
        Node pro = findPre(root.right);
        if(root.left!=null&&pre!=null)
        {
            pre.right=root;
            root.left=pre;
        }
        if(root.right!=null&&pro!=null){
            root.right=pro;
            pro.left=root;
        }
        return pre;
    }

    private Node findPre(Node cur) {
        Node root=cur;
        if(root==null)return null;
        while (root.left != null) {
            root=root.left;
        }
        return root;
    }
    private Node findPro(Node cur) {
        Node root=cur;
        if(root==null)return null;
        while (root.right != null) {
            root=root.right;
        }
        return root;
    }
}

