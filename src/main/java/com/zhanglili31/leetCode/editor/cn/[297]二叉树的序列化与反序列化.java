package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//297 二叉树的序列化与反序列化
//2022-05-02 19:18:47
class SerializeAndDeserializeBinaryTree {

//    public static void main(String[] args) {
//        Solution solution = new SerializeAndDeserializeBinaryTree().new Solution();
//        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
//        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
//        String testStr="hello";
//        int temp[] = {-1,0,1,2,-1,-4};
//        System.out.println(solution);
//    }

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
    class Codec {

        // Encodes a tree to a single string.

        public String serialize(TreeNode root) {
            StringBuilder res = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            if (root == null)
                return res.toString();
            queue.add(root);
            TreeNode node = null;
            while (!queue.isEmpty()) {
                node = queue.poll();
                if (node != null) {
                    res.append(String.valueOf(node.val) + ",");
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    res.append("null,");
                }
            }
            return res.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals(""))
                return null;
            String values[] = data.split(",");
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            TreeNode root = null;
            if (values.length != 0) {
                root = new TreeNode(Integer.valueOf(values[0]));
                queue.add(root);
            }
            for (int i = 0; i < values.length; ) {
                TreeNode node = queue.poll();
                if (++i < values.length && !"null".equals(values[i])) {

                    node.left = new TreeNode(Integer.valueOf(values[i]));
                    queue.add(node.left);
                }
                if (++i < values.length && !"null".equals(values[i])) {
                    node.right = new TreeNode(Integer.valueOf(values[i]));
                    queue.add(node.right);
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}