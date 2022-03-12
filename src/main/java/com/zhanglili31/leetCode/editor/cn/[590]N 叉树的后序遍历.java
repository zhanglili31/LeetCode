package com.zhanglili31.leetCode.editor.cn;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//590N 叉树的后序遍历
//2021-03-19 00:05:39
class NAryTreePostorderTraversal{
    public static void main(String []args){
        Solution solution=new NAryTreePostorderTraversal().new Solution();
        TreeNode r=CreateTree.deserialize("[5,4,2,3,3,7]");
        System.out.println(solution);
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
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        recure(root, list);
        return list;
    }

    public void recure(Node root, List E) {
        if(root==null)return;
        for(int i=0;i<root.children.size();i++){
            recure(root.children.get(i), E);
        }
        E.add(root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
