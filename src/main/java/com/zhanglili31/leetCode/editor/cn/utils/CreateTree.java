package com.zhanglili31.leetCode.editor.cn.utils;

import java.util.LinkedList;
import java.util.Queue;

public class CreateTree {
    //层次遍历二叉树的结果，返回字符串
    public static String serialize(TreeNode root) {
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


    // 输入是一个层次遍历的二叉树字符串，输出是一个对应的二叉树.
    public static TreeNode deserialize(String data) {
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
                node.left = i<strArr.length&&!"null".equals(strArr[i]) ?
                        new TreeNode(Integer.valueOf(strArr[i])) :
                        null;
                i++;
                node.right = i<strArr.length&&!"null".equals(strArr[i]) ?
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
