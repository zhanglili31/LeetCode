package com.zhanglili31.leetCode.editor.cn;

import java.util.*;

//589N 叉树的前序遍历
//2021-03-18 23:55:22
class NAryTreePreorderTraversal{
    public static void main(String []args){
        Solution solution=new NAryTreePreorderTraversal().new Solution();
//        TreeNode r=CreateTree.deserialize("[1,null,3,2,4,null,5,6]");
//        System.out.println(solution.preorder(r));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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


class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<Node>();
        Node node=null;
        stack.add(root);
        while(!stack.isEmpty()){
            node = stack.pollLast();
            if (node != null) {
                list.add(node.val);
                Collections.reverse(node.children);
                for(Node temp:node.children){
                    stack.add(temp);
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
