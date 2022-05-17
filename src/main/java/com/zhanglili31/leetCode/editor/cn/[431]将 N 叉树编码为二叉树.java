package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//431 将 N 叉树编码为二叉树
//2022-05-17 09:50:54
class EncodeNAryTreeToBinaryTree {

    public static void main(String[] args) {
//        Solution solution = new EncodeNAryTreeToBinaryTree().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
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
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 解决方案：https://leetcode.cn/problems/encode-n-ary-tree-to-binary-tree/
/*class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root==null)return null;
        TreeNode treeNode=new TreeNode(root.val);
        TreeNode last=null;
        for(Node child:root.children){
            if (last != null) {
                last.right = encode(child);
                last=last.right;
            }else{
                treeNode.left=encode(child);
                last=treeNode.left;
            }
        }
        return treeNode;
    }

	
    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root){
        return decode(root, null);
    }
    public Node decode(TreeNode root,List<Node>list) {
        if(root==null)return null;
        Node node = new Node(root.val, new ArrayList<Node>());
        if (list != null) {
            list.add(node);
        }
        if (root.left != null) {
            decode(root.left,node.children);
        }
        if (root.right != null) {
            decode(root.right, list);
        }
        return node;
        
    }
}*/

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));
//leetcode submit region end(Prohibit modification and deletion)
 
}