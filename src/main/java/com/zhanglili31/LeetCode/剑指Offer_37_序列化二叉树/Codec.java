package com.zhanglili31.LeetCode.剑指Offer_37_序列化二叉树;

import java.net.BindException;
import java.util.LinkedList;
import java.util.Queue;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//left=root*2+1
//right=root*2+2
public class Codec {
    // Encodes a tree to a single string.
    public static void main(String[] args) {
        new Codec().deserialize("[5,2,3,null,null,2,4,3,1]");
//        TreeNode root = new TreeNode(1);
//        TreeNode r2 = new TreeNode(2);
//        TreeNode r3 = new TreeNode(3);
//        TreeNode r4 = new TreeNode(4);
//        TreeNode r5 = new TreeNode(5);
//        root.left = r2;
//        root.right = r3;
//        r3.left = r4;
//        r3.right = r5;
//        String res = new Codec().serialize(root);
//        System.out.println(res);
//        TreeNode r6 = new TreeNode(6);
//        TreeNode r7 = new TreeNode(7);
    }

    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp = null;
        StringBuffer strB = new StringBuffer();
        strB.append("[");
        while (queue.size() > 0) {
            if ((temp = queue.poll()) != null) {
                queue.add(temp.left);
                queue.add(temp.right);
                strB.append(String.valueOf(temp.val) + ",");
            } else {
                strB.append("null,");
            }
        }
        strB.replace(strB.length() - 1, strB.length(), "]");
        return strB.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String temp = data.substring(1, data.length() - 1);
        String[] strArr = temp.split(",");
        if(strArr[0].equals("null"))return null;
        TreeNode root = new TreeNode(Integer.valueOf(strArr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = null;
        int i = 1;
        while (queue.size() > 0 && i < strArr.length) {
            node = queue.poll();
            if (node != null) {
                node.left = !"null".equals(strArr[i]) ?
                        new TreeNode(Integer.valueOf(strArr[i])) :
                        null;
                i++;
                node.right = !"null".equals(strArr[i]) ?
                        new TreeNode(Integer.valueOf(strArr[i])) :
                        null;
                i++;
                queue.add(node.left);
                queue.add(node.right);
            }

        }
        return root;
    }
}